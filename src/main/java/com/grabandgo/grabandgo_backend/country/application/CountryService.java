package com.grabandgo.grabandgo_backend.country.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.country.domain.Country;
import com.grabandgo.grabandgo_backend.country.domain.DTO.CountryDTO;

/**
 * CountryService
 */

public interface CountryService {
    Country saveCountry(Country country);

    Country updateCountry(Long id, Country country);

    void deleteCountry(Long id);

    List<CountryDTO> findAll();

    Optional<CountryDTO> findById(Long id);

    List<CountryDTO> findAllView();
}