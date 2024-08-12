package com.grabandgo.grabandgo_backend.supplierContact.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;
import com.grabandgo.grabandgo_backend.supplierContact.domain.DTO.SupplierContactDTO;

/**
 * SupplierContactServiceImpl
 */
public interface SupplierContactService {

    SupplierContact saveSupplierContact(SupplierContact supplierContact);

    SupplierContact updateSupplierContact(Long id, SupplierContact supplierContact);

    void deleteSupplierContact(Long id);

    List<SupplierContactDTO> findAll();

    Optional<SupplierContactDTO> getById(Long id);
}