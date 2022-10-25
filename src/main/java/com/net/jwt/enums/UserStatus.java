package com.net.jwt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {

    ACTIVE(0L),
    INACTIVE(1L),
    BLOCKED(2L),
    MAIN(3L);

    private final Long value;

}