package com.grabandgo.grabandgo_backend.supplier.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;

public interface SupplierService {

    Supplier saveSupplier(Supplier supplier);

    Supplier updateSupplier(String id, Supplier supplier);

    void deleteSupplier(String id);

    Optional<Supplier> getSupplierById(String id);

    List<Supplier> fetchSuppliersList();

}