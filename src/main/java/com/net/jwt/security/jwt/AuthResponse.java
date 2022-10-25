package com.net.jwt.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthResponse {

    private final String username;

    private final String accessToken;

    private final String refreshToken;

}
