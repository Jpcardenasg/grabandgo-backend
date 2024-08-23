package com.grabandgo.grabandgo_backend.customer.domain.DTO;

import com.grabandgo.grabandgo_backend.user.domain.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String id;
    private String name;
    private String email;
    private String lastName;
    private UserDTO user;
    private String address;
    private String postalCode;
    private Long cityId;
    private String cityName;
    private Long phoneNumber;
    private Long phoneId;
}