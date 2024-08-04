package com.grabandgo.grabandgo_backend.productGamma.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.productGamma.domain.ProductGamma;

@Repository
public interface ProductGammaRepository extends JpaRepository<ProductGamma, Long> {
}