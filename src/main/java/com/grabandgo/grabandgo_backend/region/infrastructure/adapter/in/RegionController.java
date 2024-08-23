package com.grabandgo.grabandgo_backend.region.infrastructure.adapter.in;

import com.grabandgo.grabandgo_backend.region.application.RegionService;
import com.grabandgo.grabandgo_backend.region.domain.DTO.RegionDTO;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/region")
public class RegionController {

    private final RegionService service;

    public RegionController(RegionService service) {
        this.service = service;
    }

    @PostMapping("/saveRegion")
    public ResponseEntity<RegionDTO> saveRegion(@Valid @RequestBody RegionDTO regionDTO) {

        try {
            service.saveRegion(regionDTO);
            return new ResponseEntity<>(regionDTO, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateRegion/{regionId}")
    public ResponseEntity<RegionDTO> updateRegion(@PathVariable Long regionId, @Valid @RequestBody RegionDTO regionDTO) {

        try {
            service.updateRegion(regionId, regionDTO);
            return  new ResponseEntity<>(regionDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteRegion/{regionId}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long regionId) {

        try {
            service.deleteRegion(regionId);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/allRegions")
    public ResponseEntity<List<RegionDTO>> findAll() {

        try {
            List<RegionDTO> regionDTOs = service.findAllRegions();
            return new ResponseEntity<>(regionDTOs, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getRegion/{id}")
    public ResponseEntity<RegionDTO> findRegionById(@PathVariable Long id) {

        try {
            RegionDTO regionDTO = service.findRegionById(id).orElse(null);
            return new ResponseEntity<>(regionDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}