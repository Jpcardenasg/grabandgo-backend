package com.grabandgo.grabandgo_backend.country.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.country.domain.Country;
import com.grabandgo.grabandgo_backend.country.domain.DTO.CountryDTO;
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
    public List<CountryDTO> findAll() {
        return countryRepository.findAll().stream().map(this::countryToDto).collect(Collectors.toList());
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
    public Optional<CountryDTO> findById(Long id) {
        return countryRepository.findById(id).map(this::countryToDto);
    }

    @Override
    public List<CountryDTO> findAllView() {
        return countryRepository.findAll().stream().map(this::countryToDto).collect(Collectors.toList());
    }

    private CountryDTO countryToDto(Country country) {
        return new CountryDTO().builder().id(country.getId()).name(country.getName()).build();
    }
}