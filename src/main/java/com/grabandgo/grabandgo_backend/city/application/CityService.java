package com.grabandgo.grabandgo_backend.city.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.city.domain.DTO.CityDTO;

/**
 * CityService
 */
public interface CityService {

    City saveCity(City city);

    City updateCity(Long id, City city);

    void deleteCity(Long id);

    List<City> findAll();

    List<CityDTO> findAllView();

    Optional<City> findById(Long id);
}