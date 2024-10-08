package com.grabandgo.grabandgo_backend.country.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grabandgo.grabandgo_backend.region.domain.Region;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @JsonManagedReference(value = "country-region")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY ,mappedBy = "country")
    private List<Region> regions;
}