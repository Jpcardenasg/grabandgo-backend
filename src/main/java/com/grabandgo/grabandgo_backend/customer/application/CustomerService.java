package com.grabandgo.grabandgo_backend.customer.application;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.customer.domain.DTO.CustomerDTO;
import com.grabandgo.grabandgo_backend.customer.domain.DTO.CustomerRegistrationDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    void saveCustomer(CustomerRegistrationDTO customerDTO);

    void updateCustomer(String id, CustomerRegistrationDTO customerDTO);

    void deleteCustomer(String id);

    List<CustomerDTO> findAllCustomers();

    Optional<CustomerDTO> findCustomerById(String id);

    CustomerDTO toDTO(Customer customer);

    Customer toEntity(CustomerRegistrationDTO customerDTO);
}