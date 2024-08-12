package com.grabandgo.grabandgo_backend.office.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.office.application.OfficeService;
import com.grabandgo.grabandgo_backend.office.domain.Office;
import com.grabandgo.grabandgo_backend.office.domain.DTO.OfficeDTO;

/**
 * OfficeAdapter
 */
@Validated
@RestController
@RequestMapping("/api/office")
public class OfficeController {

    @Autowired
    private OfficeService service;

    @PostMapping("/saveOffice")
    public ResponseEntity<Office> saveOffice(@Valid @RequestBody Office office) {
        service.saveOffice(office);
        return ResponseEntity.ok(office);
    }

    @PutMapping("/updateOffice/{officeId}")
    public ResponseEntity<Office> updateOffice(@PathVariable Long officeId, @Valid @RequestBody Office office) {
        service.updateOffice(officeId, office);
        return ResponseEntity.ok(office);
    }

    @DeleteMapping("/deleteOffice/{officeId}")
    public ResponseEntity<Long> deleteOffice(@PathVariable Long officeId) {
        service.deleteOffice(officeId);
        return ResponseEntity.ok(officeId);
    }

    @GetMapping("/allOffices")
    public ResponseEntity<List<OfficeDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/getOffice/{id}")
    public ResponseEntity<OfficeDTO> getOfficeByid(@PathVariable Long id) {
        return ResponseEntity.of(service.findById(id));
    }
}