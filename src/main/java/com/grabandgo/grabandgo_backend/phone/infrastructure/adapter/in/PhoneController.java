package com.grabandgo.grabandgo_backend.phone.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.phone.application.PhoneService;
import com.grabandgo.grabandgo_backend.phone.domain.Phone;
import com.grabandgo.grabandgo_backend.phone.domain.DTO.PhoneDTO;
import org.springframework.web.bind.annotation.RequestParam;


@Validated
@RestController
@RequestMapping("/api/phone")
public class PhoneController {

    @Autowired
    private PhoneService service;

    @PostMapping("/savePhone")
    public ResponseEntity<Phone> savePhone(@Valid @RequestBody Phone phone) {
        service.savePhone(phone);
        return ResponseEntity.ok(phone);
    }

    @PutMapping("/updatePhone/{phoneId}")
    public ResponseEntity<Phone> updatePhone(@PathVariable Long phoneId, @Valid @RequestBody Phone phone) {
        service.updatePhone(phoneId, phone);
        return ResponseEntity.ok(phone);
    }

    @DeleteMapping("/deletePhone/{phoneId}")
    public ResponseEntity<Long> deletePhone(@PathVariable Long phoneId) {
        service.deletePhone(phoneId);
        return ResponseEntity.ok(phoneId);
    }

    @GetMapping("/allPhones")
    public ResponseEntity<List<PhoneDTO>> findAll() {
        return ResponseEntity.ok(service.fetchPhonesList());
    }

    @GetMapping("/getPhone/{id}")
    public ResponseEntity<PhoneDTO> getMethodName(@RequestParam Long id) {
        return ResponseEntity.ok(service.getPhoneById(id));
    }
    
}