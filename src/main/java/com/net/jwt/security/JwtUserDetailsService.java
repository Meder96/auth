package com.net.jwt.security;

import com.net.jwt.entity.User;
import com.net.jwt.repository.UserRepository;
import com.net.jwt.security.jwt.JwtUser;
import com.net.jwt.security.jwt.JwtUserFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (isNull(user)) {
            throw new UsernameNotFoundException("Пользователь не найден.");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);


        log.info("LoadByUserName: success - {}", user);
        return jwtUser;
    }
}
