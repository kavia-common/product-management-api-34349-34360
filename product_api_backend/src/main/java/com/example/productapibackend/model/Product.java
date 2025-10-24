package com.example.productapibackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

/**
 * Product JPA entity representing a product with name, price and quantity.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name must not be blank")
    @Column(nullable = false)
    private String name;

    @DecimalMin(value = "0.0", inclusive = true, message = "price must be greater than or equal to 0")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

    @Min(value = 0, message = "quantity must be greater than or equal to 0")
    @Column(nullable = false)
    private Integer quantity;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // PUBLIC_INTERFACE
    public Long getId() {
        /** Returns the product ID. */
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // PUBLIC_INTERFACE
    public String getName() {
        /** Returns the product name. */
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // PUBLIC_INTERFACE
    public BigDecimal getPrice() {
        /** Returns the product price. */
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // PUBLIC_INTERFACE
    public Integer getQuantity() {
        /** Returns the product quantity. */
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
