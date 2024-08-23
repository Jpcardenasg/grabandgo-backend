package com.grabandgo.grabandgo_backend.city.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.city.domain.DTO.CityDTO;
import com.grabandgo.grabandgo_backend.city.infrastructure.adapter.out.CityRepository;
import com.grabandgo.grabandgo_backend.region.application.RegionService;
import com.grabandgo.grabandgo_backend.region.domain.DTO.RegionDTO;
import com.grabandgo.grabandgo_backend.region.domain.Region;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final RegionService regionService;

    public CityServiceImpl(CityRepository cityRepository, RegionService regionService) {
        this.cityRepository = cityRepository;
        this.regionService = regionService;
    }

    @Transactional
    @Override
    public void saveCity(CityDTO cityDTO) {
        City city = toEntity(cityDTO);
        cityRepository.save(city);
    }

    @Transactional
    @Override
    public void updateCity(Long id, CityDTO cityDTO) {
        if (cityRepository.existsById(id)) {
            City city = toEntity(cityDTO);
            city.setId(id);
            cityRepository.save(city);
        } else {
            throw new RuntimeException("City not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<CityDTO> findCityById(Long id) {
        return cityRepository.findById(id).map(this::toDTO);
    }

    @Transactional
    @Override
    public List<CityDTO> findAllCities() {
        return cityRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public City toEntity(CityDTO cityDTO) {

        City city = new City();
        city.setId(cityDTO.getId());
        city.setName(cityDTO.getName());

        RegionDTO regionDTO = regionService.findRegionById(cityDTO.getRegionId()).orElse(null);
        Region region = regionService.toEntity(regionDTO);
        city.setRegion(region);

       return city;
    }

    @Override
    public CityDTO toDTO(City city) {

        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setRegionId(city.getRegion().getId());
        cityDTO.setRegionName(city.getRegion().getName());

        return cityDTO;
    }

}