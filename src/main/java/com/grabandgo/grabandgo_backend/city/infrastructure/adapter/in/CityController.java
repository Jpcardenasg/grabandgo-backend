package com.grabandgo.grabandgo_backend.city.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.city.domain.DTO.CityDTO;
import com.grabandgo.grabandgo_backend.city.application.CityService;

/**
 * CityAdapter
 */
@Validated
@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService service;

    @PostMapping("/saveCity")
    public ResponseEntity<City> saveCity(@Valid @RequestBody City city) {
        service.saveCity(city);
        return ResponseEntity.ok(city);
    }

    @PutMapping("/updateCity/{cityId}")
    public ResponseEntity<City> updateCity(@PathVariable Long cityId, @Valid @RequestBody City city) {
        service.updateCity(cityId, city);
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("/deleteCity/{cityId}")
    public ResponseEntity<Long> deleteCity(@PathVariable Long cityId) {
        service.deleteCity(cityId);
        return ResponseEntity.ok(cityId);
    }

    @GetMapping("/allCities")
    public ResponseEntity<List<CityDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/getCity/{id}")
    public ResponseEntity<CityDTO> getCityByid(@PathVariable Long id) {
        return ResponseEntity.of(service.findById(id));
    }

    @GetMapping("/allCitiesView")
    public ResponseEntity<List<CityDTO>> findAllView() {
        return ResponseEntity.ok(service.findAllView());
    }
}