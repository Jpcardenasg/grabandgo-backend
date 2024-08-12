package com.grabandgo.grabandgo_backend.phone.domain.DTO;

import java.util.ArrayList;
import java.util.List;

import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;
import com.grabandgo.grabandgo_backend.phone.domain.Phone;
import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;

import lombok.Data;

/**
 * PhoneDTO
 */
@Data
public class PhoneDTO {

    private Long id;
    private Long prefix;
    private Long number;
    private Long phoneType;
    private List<CustomerContact> customerContacts = new ArrayList<>();
    private List<SupplierContact> supplierContacts = new ArrayList<>();

    public PhoneDTO(Phone p) {
        id = p.getId();
        prefix = p.getPrefix();
        number = p.getNumber();
        customerContacts = p.getCustomerContacts();
        supplierContacts = p.getSupplierContacts();
    }
}