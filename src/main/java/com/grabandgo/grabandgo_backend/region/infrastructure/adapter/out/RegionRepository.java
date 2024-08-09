package com.grabandgo.grabandgo_backend.region.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.region.domain.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}