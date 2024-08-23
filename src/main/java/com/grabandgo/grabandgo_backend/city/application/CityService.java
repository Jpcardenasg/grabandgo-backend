package com.grabandgo.grabandgo_backend.city.application;

import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.city.domain.DTO.CityDTO;

import java.util.List;
import java.util.Optional;

public interface CityService {

    void saveCity(CityDTO cityDTO);

    void updateCity(Long id, CityDTO cityDTO);

    void deleteCity(Long id);

    List<CityDTO> findAllCities();

    Optional<CityDTO> findCityById(Long id);

    CityDTO toDTO(City city);

    City toEntity(CityDTO cityDTO);
}