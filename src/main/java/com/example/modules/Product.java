package com.example.modules;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product { // Измененное имя сущности
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId; // Измененный тип и имя переменной

    @Column(name = "product_name", length = 100, nullable = false)
    private String productName; // Измененный тип и имя переменной

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private Double price; // Измененный тип и имя переменной

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity; // Измененный тип и имя переменной

    // Constructors
    public Product() {
    }

    public Product(String productName, Double price, Integer stockQuantity) {
        this.productName = productName;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters and setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
