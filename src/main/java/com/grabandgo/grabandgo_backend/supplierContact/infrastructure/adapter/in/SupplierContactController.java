package com.grabandgo.grabandgo_backend.supplierContact.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.supplierContact.application.SupplierContactService;
import com.grabandgo.grabandgo_backend.supplierContact.domain.SupplierContact;
import com.grabandgo.grabandgo_backend.supplierContact.domain.DTO.SupplierContactDTO;

/**
 * BranchContactAdapter
 */
@Validated
@RestController
@RequestMapping("/api/supplierContact")
public class SupplierContactController {
    @Autowired
    private SupplierContactService service;

    @PostMapping("/saveSupplierContact")
    public ResponseEntity<SupplierContact> saveSupplierContact(@Valid @RequestBody SupplierContact supplierContact) {
        service.saveSupplierContact(supplierContact);
        return ResponseEntity.ok(supplierContact);
    }

    @PutMapping("/updateSupplierContact/{SupplierContactId}")
    public ResponseEntity<SupplierContact> updateSupplierContact(@PathVariable Long supplierContactId,
            @Valid @RequestBody SupplierContact supplierContact) {
        service.updateSupplierContact(supplierContactId, supplierContact);
        return ResponseEntity.ok(supplierContact);
    }

    @DeleteMapping("/deleteSupplierContact/{supplierContactId}")
    public ResponseEntity<Long> deleteSupplierContact(@PathVariable Long supplierContactId) {
        service.deleteSupplierContact(supplierContactId);
        return ResponseEntity.ok(supplierContactId);
    }

    @GetMapping("/allSupplierContacts")
    public ResponseEntity<List<SupplierContactDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}