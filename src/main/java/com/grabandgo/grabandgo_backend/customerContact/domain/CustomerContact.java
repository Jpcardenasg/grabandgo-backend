package com.grabandgo.grabandgo_backend.customerContact.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.phone.domain.Phone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Contact
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerContact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;

    @JsonBackReference(value = "customers-contact")
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @JsonBackReference(value = "contact-phone")
    @ManyToOne
    @JoinColumn(name = "phoneId")
    private Phone phone;

}