package com.grabandgo.grabandgo_backend.customer.domain.DTO;

import com.grabandgo.grabandgo_backend.user.domain.DTO.UserRegistrationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegistrationDTO {

    private String id;
    private String name;
    private String email;
    private String lastName;
    private UserRegistrationDTO user;
    private String address;
    private String postalCode;
    private Long cityId;
    private String cityName;
    private Long phoneNumber;
    private Long phoneId;
}