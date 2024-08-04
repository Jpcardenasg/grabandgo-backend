package com.grabandgo.grabandgo_backend.city.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.city.infrastructure.adapter.out.CityRepository;

/**
 * CityServiceImp
 */
@Service
public class CityServiceImp implements CityService {

    @Autowired
    private CityRepository CityRepository;

    @Override
    public void deleteCity(Long id) {
        CityRepository.deleteById(id);
    }

    @Override
    public List<City> findAll() {
        return CityRepository.findAll();
    }

    @Override
    public City saveCity(City city) {
        return CityRepository.save(city);
    }

    @Override
    public City updateCity(Long id, City city) {
        City cityToUpdate = CityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
        cityToUpdate.setName(city.getName());
        return CityRepository.save(cityToUpdate);
    }
}
