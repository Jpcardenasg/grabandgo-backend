package com.grabandgo.grabandgo_backend.product.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}