package com.grabandgo.grabandgo_backend.city.infrastructure.adapter.out;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.city.domain.City;

/**
 * CityRepository
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> finByName();

}