package com.grabandgo.grabandgo_backend.region.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.region.domain.DTO.Region;

public interface RegionService {

    Region saveRegion(Region region);

    Region updateRegion(Long id, Region region);

    void deleteRegion(Long id);

    Region getRegionById(Long id);

    List<Region> fetchRegionsList();

}