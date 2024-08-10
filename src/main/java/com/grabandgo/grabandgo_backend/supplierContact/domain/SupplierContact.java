package com.grabandgo.grabandgo_backend.supplierContact.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grabandgo.grabandgo_backend.phone.domain.Phone;
import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastName;
    private String email;

    @JsonBackReference(value = "supplier-suplppierContact")
    @ManyToOne
    @JoinColumn(name = "supplierNit")
    private Supplier supplier;

    @JsonBackReference(value = "phone-suplppierContact")
    @ManyToOne
    @JoinColumn(name = "phoneId")
    private Phone phone;
}