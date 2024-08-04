package com.grabandgo.grabandgo_backend.productGamma.domain;

import java.util.List;

import com.grabandgo.grabandgo_backend.product.domain.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductGamma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String textDescription;
    private String htmlDescription;
    private String image;

    @OneToMany(mappedBy = "productGamma")
    List<Product> products;
}