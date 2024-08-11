package com.grabandgo.grabandgo_backend.country.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.country.domain.Country;
import com.grabandgo.grabandgo_backend.country.infrastructure.adapter.out.CountryRepository;

import jakarta.transaction.Transactional;
/**
 * CountryServiceImpl
 */
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Transactional
    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    @Override
    public Country updateCountry(Long id, Country country) {
        if (countryRepository.existsById(id)) {
            country.setId(id);
            return countryRepository.save(country);
        } else {
            throw new RuntimeException("country not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }
}