package com.grabandgo.grabandgo_backend.customer.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.customer.infrastructure.adapter.out.CustomerRepository;

/**
 * CustomerServiceImp
 */
@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerToUpdate.setAddress1(customer.getAddress1());
        customerToUpdate.setAddress2(customer.getAddress2());
        customerToUpdate.setIdCity(customer.getIdCity());
        customerToUpdate.setIdEmployee(customer.getIdEmployee());
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setPostalCode(customer.getPostalCode());
        return customerRepository.save(customerToUpdate);
    }
}