package com.grabandgo.grabandgo_backend.supplier.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {
}
