package com.grabandgo.grabandgo_backend.customer.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.customer.domain.DTO.CustomerDTO;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(String id, Customer customer);

    void deleteCustomer(String id);

    Optional<CustomerDTO> findById(String id);

    List<CustomerDTO> fetchCustomersList();

}