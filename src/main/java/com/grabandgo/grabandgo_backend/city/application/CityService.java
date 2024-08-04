package com.grabandgo.grabandgo_backend.city.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.city.domain.City;

/**
 * CityService
 */
public interface CityService {

    City saveCity(City city);

    City updateCity(Long id, City city);

    void deleteCity(Long id);

    List<City> findAll();
}