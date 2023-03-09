package com.research.datagenerator.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    BUYER("BUYER"),
    SELLER("SELLER"),
    ADMIN("ADMIN");


    private final String label;
}
