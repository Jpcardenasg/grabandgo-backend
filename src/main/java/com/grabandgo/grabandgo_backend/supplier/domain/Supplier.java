package com.grabandgo.grabandgo_backend.supplier.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grabandgo.grabandgo_backend.branch.domain.Branch;
import com.grabandgo.grabandgo_backend.product.domain.Product;
import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    private String nit;
    private String name;

    @JsonManagedReference(value = "supplier-suplppierContact")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "supplier")
    private List<SupplierContact> supplierContacts;

    @JsonManagedReference(value = "supplier-product")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "supplier")
    private List<Product> products;

    @JsonManagedReference(value = "supplier-branch")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "supplier")
    private List<Branch> branchs;
}