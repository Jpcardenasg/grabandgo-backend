package com.grabandgo.grabandgo_backend.customercontact.infrastructure.adapter.in;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grabandgo.grabandgo_backend.customercontact.application.CustomerContactService;
import com.grabandgo.grabandgo_backend.customercontact.domain.CustomerContact;

/**
 * ContactAdapter
 */
@RestController
public class CustomerContactController {
    @Autowired
    private CustomerContactService service;

    @PostMapping("/savecustomerContact")
    public ResponseEntity<CustomerContact> saveCustomerContact(@RequestBody CustomerContact customerContact) {
        service.saveCustomerContact(customerContact);
        return ResponseEntity.ok(customerContact);
    }

    @PutMapping("/updateCustomerContact/{customerContactId}")
    public ResponseEntity<CustomerContact> updateCustomerContact(@PathVariable Long customerContactId,
            @RequestBody CustomerContact customerContact) {
        service.updateCustomerContact(customerContactId, customerContact);
        return ResponseEntity.ok(customerContact);
    }

    @DeleteMapping("/deleteCustomerContact/{customerContactId}")
    public ResponseEntity<Long> deleteCustomerContact(@PathVariable Long customerContactId) {
        service.deleteCustomerContact(customerContactId);
        return ResponseEntity.ok(customerContactId);
    }

    @GetMapping("/allCustomerContacts")
    public ResponseEntity<List<CustomerContact>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}