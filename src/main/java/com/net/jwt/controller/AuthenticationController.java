package com.net.jwt.controller;

import com.net.jwt.security.jwt.AuthForm;
import com.net.jwt.security.jwt.AuthResponse;
import com.net.jwt.security.jwt.RefreshForm;
import com.net.jwt.service.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/api/auth/")
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("sign-in")
    public AuthResponse login(@RequestBody AuthForm form) {
        return userService.login(form);
    }

    @PostMapping("refresh")
    public AuthResponse refresh(@RequestBody RefreshForm form) {
        return userService.refresh(form);
    }




}
