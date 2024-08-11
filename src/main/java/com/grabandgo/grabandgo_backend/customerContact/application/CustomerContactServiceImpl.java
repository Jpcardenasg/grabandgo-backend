package com.grabandgo.grabandgo_backend.customerContact.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;
import com.grabandgo.grabandgo_backend.customerContact.infrastructure.adapter.out.CustomerContactRepository;

import jakarta.transaction.Transactional;

/**
 * CustomerContactServiceImpl
 */
@Service
public class CustomerContactServiceImpl implements CustomerContactService {

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Transactional
    @Override
    public void deleteCustomerContact(Long id) {
        customerContactRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<CustomerContact> findAll() {
        return customerContactRepository.findAll();
    }

    @Transactional
    @Override
    public CustomerContact saveCustomerContact(CustomerContact customerContact) {
        return customerContactRepository.save(customerContact);
    }

    @Transactional
    @Override
    public CustomerContact updateCustomerContact(Long id, CustomerContact customerContact) {
        if (customerContactRepository.existsById(id)) {
            customerContact.setId(id);
            return customerContactRepository.save(customerContact);
        } else {
            throw new RuntimeException("customerContact not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public Optional<CustomerContact> findById(Long id) {
        return customerContactRepository.findById(id);
    }
}
