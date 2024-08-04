package com.grabandgo.grabandgo_backend.phoneType.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.phoneType.application.PhoneTypeService;
import com.grabandgo.grabandgo_backend.phoneType.domain.PhoneType;

@RestController
@RequestMapping("/api/phoneType")
public class PhoneTypeController {

    @Autowired
    private PhoneTypeService service;

    @PostMapping("/savePhoneType")
    public ResponseEntity<PhoneType> savePhoneType(@RequestBody PhoneType phoneType) {
        service.savePhoneType(phoneType);
        return ResponseEntity.ok(phoneType);
    }

    @PutMapping("/updatePhoneType/{phoneTypeId}")
    public ResponseEntity<PhoneType> updatePhoneType(@PathVariable Long phoneTypeId, @RequestBody PhoneType phoneType) {
        service.updatePhoneType(phoneTypeId, phoneType);
        return ResponseEntity.ok(phoneType);
    }

    @DeleteMapping("/deletePhoneType/{phoneTypeId}")
    public ResponseEntity<Long> deletePhoneType(@PathVariable Long phoneTypeId) {
        service.deletePhoneType(phoneTypeId);
        return ResponseEntity.ok(phoneTypeId);
    }

    @GetMapping("/allPhoneTypes")
    public ResponseEntity<List<PhoneType>> findAll() {
        return ResponseEntity.ok(service.fetchPhoneTypesList());
    }
}