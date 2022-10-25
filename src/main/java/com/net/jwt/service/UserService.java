package com.net.jwt.service;

import com.net.jwt.entity.User;
import com.net.jwt.security.jwt.AuthForm;
import com.net.jwt.security.jwt.AuthResponse;
import com.net.jwt.security.jwt.JwtUser;
import com.net.jwt.security.jwt.RefreshForm;

import java.util.List;

public interface UserService {

    AuthResponse login(AuthForm form);

    AuthResponse refresh(RefreshForm form);

    List<User> findAll();

    User findByUserName(String userName);

    User findById(Long id);

    User save(User user);

    User profile(JwtUser jwtUser);

}
