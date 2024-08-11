package com.grabandgo.grabandgo_backend.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.grabandgo.grabandgo_backend.auth.model.LoginRequest;
import com.grabandgo.grabandgo_backend.auth.model.RegisterRequest;
import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.customer.infrastructure.adapter.out.CustomerRepository;
import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;
import com.grabandgo.grabandgo_backend.jwt.JwtService;
import com.grabandgo.grabandgo_backend.phone.domain.Phone;
import com.grabandgo.grabandgo_backend.user.domain.Role;
import com.grabandgo.grabandgo_backend.user.domain.User;
import com.grabandgo.grabandgo_backend.auth.model.AuthResponse;

import com.grabandgo.grabandgo_backend.customerContact.infrastructure.adapter.out.CustomerContactRepository;
import com.grabandgo.grabandgo_backend.phone.infrastructure.adapter.out.PhoneRepository;
import com.grabandgo.grabandgo_backend.user.infrastructure.out.UserRepository;

import jakarta.transaction.Transactional;

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
    private final CustomerContactRepository customerContactRepository;
    private final PhoneRepository phoneRepository;
    private final CustomerRepository customerRepository;

	@Transactional
    public AuthResponse login(LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        Role userRole = userRepository.findByUsername(request.getUsername()).orElseThrow().getRole();
        UserDetails userDetails = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder()
                .token(token)
                .username(request.getUsername())
                .role(userRole)
                .build();
    }

	@Transactional
    public AuthResponse register(RegisterRequest request) {

        // CREATE
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .build();

        // CREATE PHONE
        Phone phone = Phone.builder()
                .number(request.getPhone().getNumber())
                .phoneType(request.getPhone().getPhoneType())
                .prefix(request.getPhone().getPrefix())
                .build();

        // CREATE CUSTOMER
        Customer customer = Customer.builder()
                .id(request.getIdNumber())
                .name(request.getName())
                .lastName(request.getLastName())
                .address(request.getAddress())
                .postalCode(request.getPostalCode())
                .city(request.getCity())
                .employee(null)
                .user(user)
                .build();

        // SAVE CUSTOMERCONTACT
        CustomerContact customerContact = CustomerContact.builder()
                .email(request.getUsername())
                .customer(customer)
                .phone(phone)
                .build();

        // ASSIGNAMENTS
        phone.getCustomerContacts().add(customerContact);
        customer.getContactsCustomer().add(customerContact);

        // SAVES
        phoneRepository.save(phone);
        userRepository.save(user);
        customerRepository.save(customer);
        customerContactRepository.save(customerContact);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

}