package com.grabandgo.grabandgo_backend.supplierContact.domain.DTO;

import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;
import lombok.Data;

/**
 * BranchContactDTO
 */
@Data
public class SupplierContactDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String supplier;
    private Long phone_id;

    public SupplierContactDTO(SupplierContact sp) {
        id = sp.getId();
        name = sp.getName();
        lastName = sp.getLastName();
        email = sp.getEmail();
        supplier = sp.getSupplier().getNit();
        phone_id = sp.getPhone().getId();
    }

}