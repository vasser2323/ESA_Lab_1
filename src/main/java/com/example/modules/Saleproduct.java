package com.example.modules;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Saleproduct { // Переименовал класс в Saleproduct (необходимо убедиться, что это соответствует требованиям ваших инструментов и настроек)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saleproduct_id")
    private Integer saleProductId;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    // Constructors
    public Saleproduct() {
        // Конструктор по умолчанию
    }

    public Saleproduct(Product product, Sale sale, Integer quantity) {
        this.product = product;
        this.sale = sale;
        this.quantity = quantity;
    }

    // Getters and setters
    public Integer getSaleProductId() {
        return saleProductId;
    }

    public void setSaleProductId(Integer saleProductId) {
        this.saleProductId = saleProductId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
