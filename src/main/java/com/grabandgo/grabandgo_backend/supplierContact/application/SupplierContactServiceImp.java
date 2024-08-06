package com.grabandgo.grabandgo_backend.supplierContact.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;
import com.grabandgo.grabandgo_backend.supplierContact.infrastructure.adapter.out.SupplierContactRepository;

/**
 * SupplierContactService
 */
@Service
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
        if (supplierContactRepository.existsById(id)) {
            supplierContact.setId(id);
            return supplierContactRepository.save(supplierContact);
        } else {
            throw new RuntimeException("supplierContact not found with id: " + id);
        }
    }
}
