package com.grabandgo.grabandgo_backend.city.infrastructure.adapter.in;

import com.grabandgo.grabandgo_backend.city.application.CityService;
import com.grabandgo.grabandgo_backend.city.domain.DTO.CityDTO;
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
@RequestMapping("/api/city")
public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @PostMapping("/saveCity")
    public ResponseEntity<CityDTO> saveCity(@Valid @RequestBody CityDTO cityDTO) {

        try {
            service.saveCity(cityDTO);
            return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCity/{cityId}")
    public ResponseEntity<CityDTO> updateCity(@PathVariable Long cityId, @Valid @RequestBody CityDTO cityDTO) {

        try {
            service.updateCity(cityId, cityDTO);
            return  new ResponseEntity<>(cityDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteCity/{cityId}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long cityId) {

        try {
            service.deleteCity(cityId);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/allCities")
    public ResponseEntity<List<CityDTO>> findAll() {

        try {
            List<CityDTO> cityDTOs = service.findAllCities();
            return new ResponseEntity<>(cityDTOs, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getCity/{id}")
    public ResponseEntity<CityDTO> findCityById(@PathVariable Long id) {

        try {
            CityDTO cityDTO = service.findCityById(id).orElse(null);
            return new ResponseEntity<>(cityDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}