package com.grabandgo.grabandgo_backend.supplier.domain.DTO;

import java.util.List;

import com.grabandgo.grabandgo_backend.branch.domain.Branch;
import com.grabandgo.grabandgo_backend.product.domain.Product;
import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;
import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;

import lombok.Data;

/**
 * SupplierDTO
 */
@Data
public class SupplierDTO {

    private String nit;
    private String name;
    private List<SupplierContact> supplierContacts;
    private List<Product> products;
    private List<Branch> branchs;

    public SupplierDTO(Supplier s) {
        nit = s.getNit();
        name = s.getName();
        supplierContacts = s.getSupplierContacts();
        products = s.getProducts();
        branchs = s.getBranchs();
    }
}