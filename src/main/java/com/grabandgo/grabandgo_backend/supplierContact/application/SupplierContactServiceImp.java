package com.grabandgo.grabandgo_backend.supplierContact.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;
import com.grabandgo.grabandgo_backend.supplierContact.infrastructure.adapter.out.SupplierContactRepository;

/**
 * SupplierContactService
 */
public class SupplierContactServiceImp implements SupplierContactService {

    @Autowired
    private SupplierContactRepository supplierContactRepository;

    @Override
    public void deleteSupplierContact(Long id) {
        supplierContactRepository.deleteById(id);
    }

    @Override
    public List<SupplierContact> findAll() {
        return supplierContactRepository.findAll();
    }

    @Override
    public SupplierContact saveSupplierContact(SupplierContact supplierContact) {
        return supplierContactRepository.save(supplierContact);
    }

    @Override
    public SupplierContact updateSupplierContact(Long id, SupplierContact supplierContact) {
        SupplierContact supplierContactToUpdate = supplierContactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SupplierContact not found"));
        supplierContactToUpdate.setEmail(supplierContact.getEmail());
        supplierContactToUpdate.setLastName(supplierContact.getLastName());
        supplierContactToUpdate.setName(supplierContact.getName());
        return supplierContactRepository.save(supplierContactToUpdate);
    }
}
