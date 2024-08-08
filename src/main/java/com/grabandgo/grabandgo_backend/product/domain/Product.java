package com.grabandgo.grabandgo_backend.product.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grabandgo.grabandgo_backend.productGamma.domain.ProductGamma;
import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private Double sellPrice;
    private Double supplierPrice;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productGamaId")
    private ProductGamma productGamma;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

}