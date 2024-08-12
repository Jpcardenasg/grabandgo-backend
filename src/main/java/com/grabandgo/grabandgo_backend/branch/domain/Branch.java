package com.grabandgo.grabandgo_backend.branch.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grabandgo.grabandgo_backend.city.domain.DTO.City;
import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Branch {

    @Id
    private Long id;
    private String direction;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "supplierNit")
    private Supplier supplier;

    @JsonBackReference("city-branches")
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

}