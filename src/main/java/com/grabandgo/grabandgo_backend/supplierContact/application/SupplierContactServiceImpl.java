package com.grabandgo.grabandgo_backend.supplierContact.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;
import com.grabandgo.grabandgo_backend.supplierContact.domain.DTO.SupplierContactDTO;
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
    public List<SupplierContactDTO> findAll() {
        return supplierContactRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
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

    @Override
    public Optional<SupplierContactDTO> getById(Long id) {
        return supplierContactRepository.findById(id).map(this::toDto);
    }

    private SupplierContactDTO toDto(SupplierContact supplierContact) {
        return new SupplierContactDTO(supplierContact);
    }
}
