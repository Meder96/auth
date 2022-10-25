package com.net.jwt.controller;

import com.net.jwt.mapper.UserEntityToUserResponseDto;
import com.net.jwt.security.jwt.JwtUser;
import com.net.jwt.service.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserEntityToUserResponseDto userEntityToUserResponseDto;

    @GetMapping("profile")
    public ResponseEntity<?> profile(@AuthenticationPrincipal JwtUser jwtUser) {
        return ResponseEntity.ok(userEntityToUserResponseDto.entityToDto(userService.profile(jwtUser)));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {

        return ResponseEntity.ok(userEntityToUserResponseDto.entityToDto(userService.findById(id)));
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> findAllUsers() {

        return ResponseEntity.ok(userEntityToUserResponseDto.entityListToDtoList(userService.findAll()));
    }



}
