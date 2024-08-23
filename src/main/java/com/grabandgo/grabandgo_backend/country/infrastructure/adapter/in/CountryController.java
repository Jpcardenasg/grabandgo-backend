package com.grabandgo.grabandgo_backend.country.infrastructure.adapter.in;

import com.grabandgo.grabandgo_backend.country.application.CountryService;
import com.grabandgo.grabandgo_backend.country.domain.DTO.CountryDTO;
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
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @PostMapping("/saveCountry")
    public ResponseEntity<CountryDTO> saveCountry(@Valid @RequestBody CountryDTO countryDTO) {

        try {
            service.saveCountry(countryDTO);
            return new ResponseEntity<>(countryDTO, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCountry/{countryId}")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable Long countryId, @Valid @RequestBody CountryDTO countryDTO) {

        try {
            service.updateCountry(countryId, countryDTO);
            return  new ResponseEntity<>(countryDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteCountry/{countryId}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long countryId) {

        try {
            service.deleteCountry(countryId);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CountryDTO>> findAll() {

        try {
            List<CountryDTO> countryDTOs = service.findAllCountries();
            return new ResponseEntity<>(countryDTOs, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getCountry/{id}")
    public ResponseEntity<CountryDTO> findCountryById(@PathVariable Long id) {

        try {
            CountryDTO countryDTO = service.findCountryById(id).orElse(null);
            return new ResponseEntity<>(countryDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}