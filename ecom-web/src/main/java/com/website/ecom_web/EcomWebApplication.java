package com.website.ecom_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.website.ecom_web")
public class EcomWebApplication {

	public static void main(String[] args) {
        System.out.println("NEW BUILD DEPLOYED");
		SpringApplication.run(EcomWebApplication.class, args);
	}

}
