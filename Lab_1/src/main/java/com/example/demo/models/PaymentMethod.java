package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "payment_methods")
public class PaymentMethod {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "method_name")
    private String methodName;
}
