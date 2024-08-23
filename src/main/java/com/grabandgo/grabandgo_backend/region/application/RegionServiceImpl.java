package com.grabandgo.grabandgo_backend.region.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.country.application.CountryService;
import com.grabandgo.grabandgo_backend.country.domain.Country;
import com.grabandgo.grabandgo_backend.country.domain.DTO.CountryDTO;
import com.grabandgo.grabandgo_backend.region.domain.DTO.RegionDTO;
import com.grabandgo.grabandgo_backend.region.domain.Region;
import com.grabandgo.grabandgo_backend.region.infrastructure.adapter.out.RegionRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final CountryService countryService;

    public RegionServiceImpl(RegionRepository regionRepository, CountryService countryService) {
        this.regionRepository = regionRepository;
        this.countryService = countryService;
    }

    @Transactional
    @Override
    public void saveRegion(RegionDTO regionDTO) {
        Region region = toEntity(regionDTO);
        regionRepository.save(region);
    }

    @Transactional
    @Override
    public void updateRegion(Long id, RegionDTO regionDTO) {
        if (regionRepository.existsById(id)) {
            Region region = toEntity(regionDTO);
            region.setId(id);
            regionRepository.save(region);
        } else {
            throw new RuntimeException("Region not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<RegionDTO> findRegionById(Long id) {
        return regionRepository.findById(id).map(this::toDTO);
    }

    @Transactional
    @Override
    public List<RegionDTO> findAllRegions() {
        return regionRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public Region toEntity(RegionDTO regionDTO) {

        Region region = new Region();
        region.setId(regionDTO.getId());
        region.setName(regionDTO.getName());

        CountryDTO countryDTO = countryService.findCountryById(regionDTO.getCountryId()).orElse(null);
        Country country = countryService.toEntity(countryDTO);
        region.setCountry(country);

        return region;
    }

    @Override
    public RegionDTO toDTO(Region region) {

        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setId(region.getId());
        regionDTO.setName(region.getName());
        regionDTO.setCountryId(region.getCountry().getId());
        regionDTO.setCountryName(region.getCountry().getName());

        return regionDTO;
    }

}

