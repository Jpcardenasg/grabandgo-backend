package com.grabandgo.grabandgo_backend.customer.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(String id, Customer customer);

    void deleteCustomer(String id);

    Optional<Customer> findById(String id);

    List<Customer> fetchCustomersList();

}