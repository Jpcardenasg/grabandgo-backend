package com.grabandgo.grabandgo_backend.customerContact.domain;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.phone.domain.Phone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Contact
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerContact {

    @Id
    private Long id;
    private String name;
    private String lastName;
    private String email;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Phone phone;

}