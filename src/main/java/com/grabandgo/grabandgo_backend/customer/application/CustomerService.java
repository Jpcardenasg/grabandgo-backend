package com.grabandgo.grabandgo_backend.customer.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);

    Customer getCustomerById(Long id);

    List<Customer> fetchCustomersList();

}