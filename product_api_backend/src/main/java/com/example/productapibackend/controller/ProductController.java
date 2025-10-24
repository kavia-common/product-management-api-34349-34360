package com.example.productapibackend.controller;

import com.example.productapibackend.model.Product;
import com.example.productapibackend.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * REST controller exposing Product CRUD endpoints under /products.
 */
@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "CRUD operations for products")
@Validated
public class ProductController {

    private final ProductService productService;

    // PUBLIC_INTERFACE
    public ProductController(ProductService productService) {
        /** Construct ProductController with ProductService dependency. */
        this.productService = productService;
    }

    // PUBLIC_INTERFACE
    @PostMapping
    @Operation(summary = "Create product", description = "Creates a new product with name, price, and quantity")
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        /** Create a new product. Returns 201 Created with Location header. */
        Product created = productService.create(product);
        return ResponseEntity.created(URI.create("/products/" + created.getId())).body(created);
    }

    // PUBLIC_INTERFACE
    @GetMapping
    @Operation(summary = "List products", description = "Returns all products")
    public List<Product> findAll() {
        /** List all products. */
        return productService.findAll();
    }

    // PUBLIC_INTERFACE
    @GetMapping("/{id}")
    @Operation(summary = "Get product by id", description = "Returns a single product by id")
    public Product findById(@PathVariable Long id) {
        /** Get product by id. */
        return productService.findById(id);
    }

    // PUBLIC_INTERFACE
    @PutMapping("/{id}")
    @Operation(summary = "Update product", description = "Updates an existing product by id")
    public Product update(@PathVariable Long id, @Valid @RequestBody Product product) {
        /** Update a product by id. */
        return productService.update(id, product);
    }

    // PUBLIC_INTERFACE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete product", description = "Deletes a product by id")
    public void delete(@PathVariable Long id) {
        /** Delete a product by id. Returns 204 No Content. */
        productService.delete(id);
    }
}
