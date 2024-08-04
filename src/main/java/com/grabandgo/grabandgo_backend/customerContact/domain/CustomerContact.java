package com.grabandgo.grabandgo_backend.customerContact.domain;

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
    @ManyToOne
    private Long idCustomer;

}