package com.grabandgo.grabandgo_backend.productDetail.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grabandgo.grabandgo_backend.product.domain.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String description;
    private String image;

    @JsonBackReference
    @OneToOne
    private Product product;
}