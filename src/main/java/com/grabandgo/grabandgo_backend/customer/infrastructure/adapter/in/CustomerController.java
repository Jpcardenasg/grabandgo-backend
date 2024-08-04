package com.grabandgo.grabandgo_backend.customer.infrastructure.adapter.in;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grabandgo.grabandgo_backend.customer.application.CustomerService;
import com.grabandgo.grabandgo_backend.customer.domain.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/saveCustomer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        service.saveCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        service.updateCustomer(customerId, customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<Long> deleteCustomer(@PathVariable Long customerId) {
        service.deleteCustomer(customerId);
        return ResponseEntity.ok(customerId);
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(service.fetchCustomersList());
    }
}