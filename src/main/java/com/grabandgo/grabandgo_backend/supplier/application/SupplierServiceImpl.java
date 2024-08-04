package com.grabandgo.grabandgo_backend.supplier.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;
import com.grabandgo.grabandgo_backend.supplier.infrastructure.adapter.out.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier updateSupplier(String id, Supplier supplier) {
        if (supplierRepository.existsById(id)) {
            supplier.setNit(id);
            return supplierRepository.save(supplier);
        } else {
            throw new RuntimeException("Supplier not found with id: " + id);
        }
    }

    @Override
    public void deleteSupplier(String id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public Supplier getSupplierById(String id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public List<Supplier> fetchSuppliersList() {
        return supplierRepository.findAll();
    }

}
