package com.grabandgo.grabandgo_backend.country.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.country.application.CountryService;
import com.grabandgo.grabandgo_backend.country.domain.Country;
import com.grabandgo.grabandgo_backend.country.domain.DTO.CountryDTO;

/**
 * CountryAdapter
 */
@Validated
@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService service;

    @PostMapping("/saveCountry")
    public ResponseEntity<Country> saveCountry(@Valid @RequestBody Country country) {
        service.saveCountry(country);
        return ResponseEntity.ok(country);
    }

    @PutMapping("/updateCountry/{countryId}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long countryId, @Valid @RequestBody Country country) {
        service.updateCountry(countryId, country);
        return ResponseEntity.ok(country);
    }

    @DeleteMapping("/deleteCountry/{countryId}")
    public ResponseEntity<Long> deleteCountry(@PathVariable Long countryId) {
        service.deleteCountry(countryId);
        return ResponseEntity.ok(countryId);
    }

    @GetMapping("/allCountries")
    public ResponseEntity<List<CountryDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/allCountriesView")
    public ResponseEntity<List<CountryDTO>> findAllLogOut() {
        return ResponseEntity.ok(service.findAllView());
    }

    @GetMapping("/getCountry/{id}")
    public ResponseEntity<CountryDTO> getCountryByid(@PathVariable Long id) {
        return ResponseEntity.of(service.findById(id));
    }
}