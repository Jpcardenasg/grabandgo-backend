package com.grabandgo.grabandgo_backend.customerContact.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;
import com.grabandgo.grabandgo_backend.customerContact.infrastructure.adapter.out.CustomerContactRepository;

/**
 * CustomerContactServiceImp
 */
@Service
public class CustomerContactServiceImp implements CustomerContactService {

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Override
    public void deleteCustomerContact(Long id) {
        customerContactRepository.deleteById(id);
    }

    @Override
    public List<CustomerContact> findAll() {
        return customerContactRepository.findAll();
    }

    @Override
    public CustomerContact saveCustomerContact(CustomerContact customerContact) {
        return customerContactRepository.save(customerContact);
    }

    @Override
    public CustomerContact updateCustomerContact(Long id, CustomerContact customerContact) {
        if (customerContactRepository.existsById(id)) {
            customerContact.setId(id);
            return customerContactRepository.save(customerContact);
        } else {
            throw new RuntimeException("customerContact not found with id: " + id);
        }
    }

    @Override
    public Optional<CustomerContact> findById(Long id) {
        return customerContactRepository.findById(id);
    }
}
