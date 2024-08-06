package com.grabandgo.grabandgo_backend.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.grabandgo.grabandgo_backend.auth.model.LoginRequest;
import com.grabandgo.grabandgo_backend.auth.model.RegisterRequest;
import com.grabandgo.grabandgo_backend.jwt.JwtService;
import com.grabandgo.grabandgo_backend.user.domain.Role;
import com.grabandgo.grabandgo_backend.user.domain.User;
import com.grabandgo.grabandgo_backend.user.infrastructure.out.UserRepository;
import com.grabandgo.grabandgo_backend.auth.model.AuthResponse;

/**
 * AuthService
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;

    public AuthResponse login(LoginRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

}