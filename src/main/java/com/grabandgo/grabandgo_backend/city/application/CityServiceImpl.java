package com.grabandgo.grabandgo_backend.city.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.city.domain.DTO.City;
import com.grabandgo.grabandgo_backend.city.domain.DTO.CityDTO;
import com.grabandgo.grabandgo_backend.city.infrastructure.adapter.out.CityRepository;

import jakarta.transaction.Transactional;

/**
 * CityServiceImpl
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<CityDTO> findAll() {
        return cityRepository.findAll().stream().map(this::cityToDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Transactional
    @Override
    public City updateCity(Long id, City city) {
        if (cityRepository.existsById(id)) {
            city.setId(id);
            return cityRepository.save(city);
        } else {
            throw new RuntimeException("city not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public Optional<CityDTO> findById(Long id) {
        return Optional.of(cityRepository.findById(id).map(this::cityToDto)).orElse(null);
    }

    @Override
    public List<CityDTO> findAllView() {
        return cityRepository.findAll().stream().map(this::cityToDto).collect(Collectors.toList());
    }

    private CityDTO cityToDto(City city) {
        new CityDTO();
        return CityDTO.builder().id(city.getId()).name(city.getName()).regionId(city.getRegion().getId()).build();
    }
}
