package com.website.ecom_web;

import com.website.ecom_web.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EcomWebApplicationTests {

    @Autowired
    private testH2repo h2repo;

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";

    private static RestTemplate restTemplate;

    @BeforeAll
    public static void init() {
        RestTemplate restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setup() {

        baseUrl = baseUrl.concat(":").concat(port+"").concat("/products");
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("headset");
        product.setDescription("Headset");

        Product response = restTemplate.postForObject(baseUrl, product, Product.class);
        Assertions.assertNotNull(response);
        assertEquals("headset", response.getName());
        assertEquals(1,h2repo.findAll().size());



    }

}
