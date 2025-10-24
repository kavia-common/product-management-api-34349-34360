package com.example.productapibackend.service;

/**
 * Exception thrown when a Product is not found by id.
 */
public class ProductNotFoundException extends RuntimeException {
    // PUBLIC_INTERFACE
    public ProductNotFoundException(Long id) {
        /** Create a not found exception for a given product id */
        super("Product not found with id: " + id);
    }
}
