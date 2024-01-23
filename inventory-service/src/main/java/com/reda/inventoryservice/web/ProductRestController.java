package com.reda.inventoryservice.web;


import com.reda.inventoryservice.entities.Product;
import com.reda.inventoryservice.repository.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    private ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @GetMapping("/products")
    @PreAuthorize("hasAuthority('user')")
    public List<Product> getAllProducts(){
    return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id){
        return productRepository.findById(id).get();
    }

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
