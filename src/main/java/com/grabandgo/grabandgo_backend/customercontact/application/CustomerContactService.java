package com.grabandgo.grabandgo_backend.customercontact.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.customercontact.domain.CustomerContact;

/**
 * ContactService
 */
public interface CustomerContactService {
    CustomerContact saveCustomerContact(CustomerContact CustomerContact);

    CustomerContact updateCustomerContact(Long id, CustomerContact CustomerContact);

    void deleteCustomerContact(Long id);

    List<CustomerContact> findAll();
}