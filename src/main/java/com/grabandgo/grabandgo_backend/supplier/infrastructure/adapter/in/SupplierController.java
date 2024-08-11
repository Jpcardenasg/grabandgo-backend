package com.grabandgo.grabandgo_backend.supplier.infrastructure.adapter.in;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grabandgo.grabandgo_backend.supplier.application.SupplierService;
import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;

@Validated
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @PostMapping("/saveSupplier")
    public ResponseEntity<Supplier> saveSupplier(@Valid @RequestBody Supplier supplier) {
        service.saveSupplier(supplier);
        return ResponseEntity.ok(supplier);
    }

    @PutMapping("/updateSupplier/{supplierId}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable String supplierId,
            @Valid @RequestBody Supplier supplier) {
        service.updateSupplier(supplierId, supplier);
        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping("/deleteSupplier/{supplierId}")
    public ResponseEntity<String> deleteSupplier(@PathVariable String supplierId) {
        service.deleteSupplier(supplierId);
        return ResponseEntity.ok(supplierId);
    }

    @GetMapping("/allSuppliers")
    public ResponseEntity<List<Supplier>> findAll() {
        return ResponseEntity.ok(service.fetchSuppliersList());
    }

    @GetMapping("/getSupplier/{nit}")
    public ResponseEntity<Supplier> getSupplierByNit(@PathVariable String nit) {
        return ResponseEntity.of(service.getSupplierById(nit));
    }

}