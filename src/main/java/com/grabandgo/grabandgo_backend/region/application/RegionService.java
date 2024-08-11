package com.grabandgo.grabandgo_backend.region.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.region.domain.Region;
import com.grabandgo.grabandgo_backend.region.domain.DTO.RegionDTO;

public interface RegionService {

    Region saveRegion(Region region);

    Region updateRegion(Long id, Region region);

    void deleteRegion(Long id);

    Region getRegionById(Long id);

    List<Region> fetchRegionsList();

    List<RegionDTO> fetchRegionsListView();

}