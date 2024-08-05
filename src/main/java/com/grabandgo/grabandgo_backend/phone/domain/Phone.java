package com.grabandgo.grabandgo_backend.phone.domain;

import java.util.List;

import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;
import com.grabandgo.grabandgo_backend.phoneType.domain.PhoneType;
import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long prefix;
    private Long number;

    @ManyToOne
    private PhoneType phoneType;

    @OneToMany(mappedBy = "phone")
    private List<CustomerContact> customerContacts;

    @OneToMany(mappedBy = "phone")
    private List<SupplierContact> supplierContacts;

}