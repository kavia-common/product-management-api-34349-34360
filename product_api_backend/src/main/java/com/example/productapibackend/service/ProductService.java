package com.example.productapibackend.service;

import com.example.productapibackend.model.Product;
import com.example.productapibackend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service layer for Product management.
 */
@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    // PUBLIC_INTERFACE
    public ProductService(ProductRepository productRepository) {
        /** Construct ProductService with ProductRepository dependency. */
        this.productRepository = productRepository;
    }

    // PUBLIC_INTERFACE
    public Product create(Product product) {
        /** Create and persist a new Product. */
        product.setId(null); // ensure create
        return productRepository.save(product);
    }

    // PUBLIC_INTERFACE
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        /** Retrieve all Products. */
        return productRepository.findAll();
    }

    // PUBLIC_INTERFACE
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        /** Retrieve a Product by id. Throws ProductNotFoundException if not found. */
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    // PUBLIC_INTERFACE
    public Product update(Long id, Product update) {
        /** Update an existing Product by id. Throws ProductNotFoundException if not found. */
        Product existing = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        existing.setName(update.getName());
        existing.setPrice(update.getPrice());
        existing.setQuantity(update.getQuantity());
        return productRepository.save(existing);
    }

    // PUBLIC_INTERFACE
    public void delete(Long id) {
        /** Delete a Product by id. Throws ProductNotFoundException if not found. */
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
