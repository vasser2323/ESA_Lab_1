package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.*;

// import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "saled_products")
public class SaledProducts {
    @Id
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "sale_id")
    private Sale sale;

    @JoinColumn(name = "product_id")
    private Product product;
}
