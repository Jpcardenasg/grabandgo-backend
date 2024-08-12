package com.grabandgo.grabandgo_backend.customer.domain.DTO;

import java.util.ArrayList;
import java.util.List;

import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;

import com.grabandgo.grabandgo_backend.order.domain.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClientDTO
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String id;
    private String name;
    private String lastName;
    private String address;
    private String postalCode;
    private Long city_id;
    private List<CustomerContact> contactsCustomer = new ArrayList<>();
    private String employee_id;
    private List<Order> orders = new ArrayList<>();
    private Long user_id;
}