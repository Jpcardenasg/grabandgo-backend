package com.grabandgo.grabandgo_backend.customerContact.infrastructure.adapter.in;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

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

import com.grabandgo.grabandgo_backend.customerContact.application.CustomerContactService;
import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;
import com.grabandgo.grabandgo_backend.customerContact.domain.DTO.CustomerContactDTO;

/**
 * ContactAdapter
 */
@Validated
@RestController
public class CustomerContactController {
    @Autowired
    private CustomerContactService service;

    @PostMapping("/savecustomerContact")
    public ResponseEntity<CustomerContact> saveCustomerContact(@Valid @RequestBody CustomerContact customerContact) {
        service.saveCustomerContact(customerContact);
        return ResponseEntity.ok(customerContact);
    }

    @PutMapping("/updateCustomerContact/{customerContactId}")
    public ResponseEntity<CustomerContact> updateCustomerContact(@PathVariable Long customerContactId,
            @Valid @RequestBody CustomerContact customerContact) {
        service.updateCustomerContact(customerContactId, customerContact);
        return ResponseEntity.ok(customerContact);
    }

    @DeleteMapping("/deleteCustomerContact/{customerContactId}")
    public ResponseEntity<Long> deleteCustomerContact(@PathVariable Long customerContactId) {
        service.deleteCustomerContact(customerContactId);
        return ResponseEntity.ok(customerContactId);
    }

    @GetMapping("/allCustomerContacts")
    public ResponseEntity<List<CustomerContactDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/getCustomerContact/{id}")
    public ResponseEntity<CustomerContactDTO> getCustomerContactByid(@PathVariable Long id) {
        return ResponseEntity.of(service.findById(id));
    }
}