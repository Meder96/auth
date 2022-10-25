package com.net.jwt.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LegalPersonType {
    HEAD(0L),
    FILIAL(1L);

    private final Long value;
}