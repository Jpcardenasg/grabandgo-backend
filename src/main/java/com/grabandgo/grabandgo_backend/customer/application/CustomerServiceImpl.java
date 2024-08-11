package com.grabandgo.grabandgo_backend.customer.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.customer.infrastructure.adapter.out.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<Customer> fetchCustomersList() {
        return customerRepository.findAll();
    }

    @Transactional
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    @Override
    public Customer updateCustomer(String id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("customer not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }
}