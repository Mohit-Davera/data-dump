package com.research.datagenerator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String adjective;

    private String material;

    private String product;

    public ProductName(String adjective, String material, String product) {
        this.adjective = adjective;
        this.material = material;
        this.product = product;
    }
}
