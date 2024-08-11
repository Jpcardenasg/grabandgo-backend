package com.grabandgo.grabandgo_backend.supplierContact.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;

/**
 * SupplierContactServiceImpl
 */
public interface SupplierContactService {

    SupplierContact saveSupplierContact(SupplierContact supplierContact);

    SupplierContact updateSupplierContact(Long id, SupplierContact supplierContact);

    void deleteSupplierContact(Long id);

    List<SupplierContact> findAll();
}