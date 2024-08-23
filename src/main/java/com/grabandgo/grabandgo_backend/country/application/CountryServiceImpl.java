package com.grabandgo.grabandgo_backend.country.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.country.domain.Country;
import com.grabandgo.grabandgo_backend.country.domain.DTO.CountryDTO;
import com.grabandgo.grabandgo_backend.country.infrastructure.adapter.out.CountryRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional
    @Override
    public void saveCountry(CountryDTO countryDTO) {
        Country country = toEntity(countryDTO);
        countryRepository.save(country);
    }

    @Transactional
    @Override
    public void updateCountry(Long id, CountryDTO countryDTO) {
        if (countryRepository.existsById(id)) {
            Country country = toEntity(countryDTO);
            country.setId(id);
            countryRepository.save(country);
        } else {
            throw new RuntimeException("Country not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<CountryDTO> findCountryById(Long id) {
        return countryRepository.findById(id).map(this::toDTO);
    }

    @Transactional
    @Override
    public List<CountryDTO> findAllCountries() {
        return countryRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public Country toEntity(CountryDTO countryDTO) {

        Country country = new Country();
        country.setId(countryDTO.getId());
        country.setName(countryDTO.getName());

        return country;
    }

    @Override
    public CountryDTO toDTO(Country country) {

        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());

        return countryDTO;
    }
}


