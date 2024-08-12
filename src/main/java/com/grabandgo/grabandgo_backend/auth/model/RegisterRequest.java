package com.grabandgo.grabandgo_backend.auth.model;

import com.grabandgo.grabandgo_backend.city.domain.DTO.City;
import com.grabandgo.grabandgo_backend.phone.domain.Phone;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * RegisterRequest
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String username;
    private String password;

    private String idNumber;
    private String name;
    private String lastName;
    private String address;
    private String postalCode;
    private String telephone;
    private City city;
    private Phone phone;
}