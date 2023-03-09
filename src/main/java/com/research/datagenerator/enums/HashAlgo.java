package com.research.datagenerator.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HashAlgo {
    SHA("SHA"),
    RSA("RSA"),
    BCRYPT("BCRYPT");


    private final String label;
}
