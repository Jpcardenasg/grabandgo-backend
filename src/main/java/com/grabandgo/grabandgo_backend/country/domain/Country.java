package com.grabandgo.grabandgo_backend.country.domain;

import java.util.List;

import com.grabandgo.grabandgo_backend.region.domain.Region;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Country
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "idCountry")
    private List<Region> regions;
}