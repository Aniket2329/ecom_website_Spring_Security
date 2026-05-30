package com.website.ecom_web;

import com.website.ecom_web.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface testH2repo extends JpaRepository<Product, Integer> {

}
