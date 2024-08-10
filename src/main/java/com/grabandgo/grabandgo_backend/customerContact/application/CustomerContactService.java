package com.grabandgo.grabandgo_backend.customerContact.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;

/**
 * ContactService
 */
public interface CustomerContactService {
    CustomerContact saveCustomerContact(CustomerContact CustomerContact);

    CustomerContact updateCustomerContact(Long id, CustomerContact CustomerContact);

    void deleteCustomerContact(Long id);

    List<CustomerContact> findAll();

    Optional<CustomerContact> findById(Long id);
}