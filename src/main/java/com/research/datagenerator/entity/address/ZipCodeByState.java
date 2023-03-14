package com.research.datagenerator.entity.address;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "address")
public class ZipCodeByState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String state;
    private String code;

    public ZipCodeByState(String state, String code) {
        this.state = state;
        this.code = code;
    }
}
