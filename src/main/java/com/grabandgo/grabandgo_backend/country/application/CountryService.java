package com.grabandgo.grabandgo_backend.country.application;

import com.grabandgo.grabandgo_backend.country.domain.Country;
import com.grabandgo.grabandgo_backend.country.domain.DTO.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    void saveCountry(CountryDTO countryDTO);

    void updateCountry(Long id, CountryDTO countryDTO);

    void deleteCountry(Long id);

    List<CountryDTO> findAllCountries();

    Optional<CountryDTO> findCountryById(Long id);

    CountryDTO toDTO(Country country);

    Country toEntity(CountryDTO countryDTO);
}