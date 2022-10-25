package com.net.jwt.service.impl;

import com.net.jwt.entity.User;
import com.net.jwt.repository.RoleRepository;
import com.net.jwt.repository.UserRepository;
import com.net.jwt.security.jwt.*;
import com.net.jwt.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Data
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public AuthResponse login(AuthForm form) {
        try {
            String userName = form.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, form.getPassword()));
            User user = findByUserName(userName);
            if (isNull(user)) {
                throw new UsernameNotFoundException("User does not exists");
            }
            String token = jwtTokenProvider.createAccessTokenLogin(userName);
            String refreshToken = jwtTokenProvider.createRefreshTokenLogin(userName);

            return new AuthResponse(user.getUserName(), token, refreshToken);

        } catch (Exception e) {
            throw new BadCredentialsException("Invalid credentials");
        }
    }

    @Override
    public AuthResponse refresh(RefreshForm form) {
        try {
            String newAccessToken = jwtTokenProvider.createAccessTokenRefresh(form.getRefreshToken());
            String newRefreshToken = jwtTokenProvider.createRefreshTokenRefresh(form.getRefreshToken());
            return new AuthResponse(jwtTokenProvider.getUsername(newRefreshToken), newAccessToken, newRefreshToken);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid credentials");
        }

    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User profile(JwtUser jwtUser) {
        return findById(jwtUser.getId());
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = userRepository.findAll();
        log.info("All users {}", allUsers);
        return allUsers;
    }

    @Override
    public User findByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        log.info("Find by user_name {}", user);
        return user;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (isNull(user)) {
            log.warn("Not found by ID user {}, ", id);
            return null;
        }
        log.info("Find by ID user {}, ", user);

        return user;
    }

}
