package com.research.datagenerator.entity.Country;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "country")
public class CountryName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
