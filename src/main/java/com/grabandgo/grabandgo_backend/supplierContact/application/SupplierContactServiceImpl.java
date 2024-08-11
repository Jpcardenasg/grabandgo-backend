package com.grabandgo.grabandgo_backend.supplierContact.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;
import com.grabandgo.grabandgo_backend.supplierContact.infrastructure.adapter.out.SupplierContactRepository;

import jakarta.transaction.Transactional;

/**
 * SupplierContactService
 */
@Service
public class SupplierContactServiceImpl implements SupplierContactService {

    @Autowired
    private SupplierContactRepository supplierContactRepository;

    @Transactional
    @Override
    public void deleteSupplierContact(Long id) {
        supplierContactRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<SupplierContact> findAll() {
        return supplierContactRepository.findAll();
    }

    @Transactional
    @Override
    public SupplierContact saveSupplierContact(SupplierContact supplierContact) {
        return supplierContactRepository.save(supplierContact);
    }

    @Transactional
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
