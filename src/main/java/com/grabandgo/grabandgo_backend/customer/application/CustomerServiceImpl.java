package com.grabandgo.grabandgo_backend.customer.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.customer.domain.DTO.CustomerDTO;
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
    public List<CustomerDTO> fetchCustomersList() {
        return customerRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
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
    public Optional<CustomerDTO> findById(String id) {
        return customerRepository.findById(id).map(this::toDto);
    }

    private CustomerDTO toDto(Customer customer){
        return CustomerDTO.builder()
            .id(customer.getId())
            .name(customer.getName())
            .lastName(customer.getLastName())
            .address(customer.getAddress())
            .postalCode(customer.getPostalCode())
            .city_id(customer.getCity().getId())
            .contactsCustomer(customer.getContactsCustomer())
            .employee_id(customer.getEmployee().getId())
            .orders(customer.getOrders())
            .user_id(customer.getUser().getId())
            .build();
    }
}