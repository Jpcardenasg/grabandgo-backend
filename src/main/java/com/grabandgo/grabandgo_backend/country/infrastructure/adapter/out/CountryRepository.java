package com.grabandgo.grabandgo_backend.country.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabandgo.grabandgo_backend.country.domain.Country;
import java.util.List;

/**
 * CountryRepository
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByName(String name);
}