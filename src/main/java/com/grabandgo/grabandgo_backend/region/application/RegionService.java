package com.grabandgo.grabandgo_backend.region.application;

import com.grabandgo.grabandgo_backend.region.domain.DTO.RegionDTO;
import com.grabandgo.grabandgo_backend.region.domain.Region;

import java.util.List;
import java.util.Optional;

public interface RegionService {

    void saveRegion(RegionDTO regionDTO);

    void updateRegion(Long id,  RegionDTO regionDTO);

    void deleteRegion(Long id);

    List<RegionDTO> findAllRegions();

    Optional<RegionDTO> findRegionById(Long id);

    RegionDTO toDTO(Region region);

    Region toEntity(RegionDTO regionDTO);
}