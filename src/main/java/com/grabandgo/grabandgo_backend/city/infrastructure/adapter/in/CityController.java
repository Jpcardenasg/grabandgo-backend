package com.grabandgo.grabandgo_backend.city.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.city.application.CityService;
import com.grabandgo.grabandgo_backend.city.domain.City;

/**
 * CityAdapter
 */
@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService service;

    @PostMapping("/saveCity")
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        service.saveCity(city);
        return ResponseEntity.ok(city);
    }

    @PutMapping("/updateCity/{cityId}")
    public ResponseEntity<City> updateCity(@PathVariable Long cityId, @RequestBody City city) {
        service.updateCity(cityId, city);
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("/deleteCity/{cityId}")
    public ResponseEntity<Long> deleteCity(@PathVariable Long cityId) {
        service.deleteCity(cityId);
        return ResponseEntity.ok(cityId);
    }

    @GetMapping("/allCities")
    public ResponseEntity<List<City>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}