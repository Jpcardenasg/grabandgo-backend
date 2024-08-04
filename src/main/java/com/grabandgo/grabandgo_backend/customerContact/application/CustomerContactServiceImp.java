package com.grabandgo.grabandgo_backend.customerContact.application;

import java.util.List;

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
    private CustomerContactRepository CustomerContactRepository;

    @Override
    public void deleteCustomerContact(Long id) {
        CustomerContactRepository.deleteById(id);
    }

    @Override
    public List<CustomerContact> findAll() {
        return CustomerContactRepository.findAll();
    }

    @Override
    public CustomerContact saveCustomerContact(CustomerContact CustomerContact) {
        return CustomerContactRepository.save(CustomerContact);
    }

    @Override
    public CustomerContact updateCustomerContact(Long id, CustomerContact CustomerContact) {
        CustomerContact CustomerContactToUpdate = CustomerContactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CustomerContact not found"));
        return CustomerContactRepository.save(CustomerContactToUpdate);
    }
}
