package com.grabandgo.grabandgo_backend.suppliercontact.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SupplierContact
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SupplierContact {

    @Id
    private Long id;
    private String name;
    private String lastName;
    private String email;

    @ManyToOne
    private Long nit;
}