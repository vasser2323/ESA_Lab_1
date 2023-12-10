package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CreditCard", schema = "public")
public class CreditCard {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "expiration_date")
    private String expiration_date;

    @Column(name = "cvv_code")
    private String cvv_code;
}
