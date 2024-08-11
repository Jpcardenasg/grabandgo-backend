package com.grabandgo.grabandgo_backend.region.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.region.domain.Region;
import com.grabandgo.grabandgo_backend.region.infrastructure.adapter.out.RegionRepository;

import jakarta.transaction.Transactional;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Transactional
    @Override
    public Region saveRegion(Region region) {
        return regionRepository.save(region);
    }

    @Transactional
    @Override
    public Region updateRegion(Long id, Region region) {
        if (regionRepository.existsById(id)) {
            region.setId(id);
            return regionRepository.save(region);
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
    public Region getRegionById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<Region> fetchRegionsList() {
        return regionRepository.findAll();
    }

}
