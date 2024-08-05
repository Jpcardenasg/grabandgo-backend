package com.grabandgo.grabandgo_backend.supplierContact.domain;

import com.grabandgo.grabandgo_backend.phone.domain.Phone;
import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;

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
    private Supplier nit;

    @ManyToOne
    private Phone phone;
}