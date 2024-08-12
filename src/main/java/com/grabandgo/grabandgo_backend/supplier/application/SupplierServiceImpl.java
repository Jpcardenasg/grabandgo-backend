package com.grabandgo.grabandgo_backend.supplier.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;
import com.grabandgo.grabandgo_backend.supplier.domain.DTO.SupplierDTO;
import com.grabandgo.grabandgo_backend.supplier.infrastructure.adapter.out.SupplierRepository;

import jakarta.transaction.Transactional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Transactional
    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Transactional
    @Override
    public Supplier updateSupplier(String id, Supplier supplier) {
        if (supplierRepository.existsById(id)) {
            supplier.setNit(id);
            return supplierRepository.save(supplier);
        } else {
            throw new RuntimeException("Supplier not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteSupplier(String id) {
        supplierRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<SupplierDTO> getSupplierById(String id) {
        return supplierRepository.findById(id).map(this::toDto);
    }

    @Transactional
    @Override
    public List<SupplierDTO> fetchSuppliersList() {
        return supplierRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private SupplierDTO toDto(Supplier supplier) {
        return new SupplierDTO(supplier);
    }

}
