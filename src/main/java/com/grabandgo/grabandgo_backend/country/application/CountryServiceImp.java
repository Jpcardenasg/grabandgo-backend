package com.grabandgo.grabandgo_backend.country.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.country.domain.Country;
import com.grabandgo.grabandgo_backend.country.infrastructure.adapter.out.CountryRepository;

/**
 * CountryServiceImp
 */
@Service
public class CountryServiceImp implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Long id, Country country) {
        Country countryToUpdate = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        return countryRepository.save(countryToUpdate);
    }
}