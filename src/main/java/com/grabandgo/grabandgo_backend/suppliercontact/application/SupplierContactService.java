package com.grabandgo.grabandgo_backend.suppliercontact.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.suppliercontact.domain.SupplierContact;

/**
 * SupplierContactServiceImp
 */
public interface SupplierContactService {

    SupplierContact saveSupplierContact(SupplierContact supplierContact);

    SupplierContact updateSupplierContact(Long id, SupplierContact supplierContact);

    void deleteSupplierContact(Long id);

    List<SupplierContact> findAll();
}