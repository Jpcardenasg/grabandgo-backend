package com.grabandgo.grabandgo_backend.country.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.country.domain.Country;

/**
 * CountryService
 */

public interface CountryService {
    Country saveCountry(Country country);

    Country updateCountry(Long id, Country country);

    void deleteCountry(Long id);

    List<Country> findAll();

}