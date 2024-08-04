package com.grabandgo.grabandgo_backend.suppliercontact.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.suppliercontact.domain.SupplierContact;

import java.util.List;

/**
 * BranchContactRepository
 */
@Repository
public interface SupplierContactRepository extends JpaRepository<SupplierContact, Long> {

    List<SupplierContact> findByName(String name);

    List<SupplierContact> findByEmail(String email);

    List<SupplierContact> findByLastName(String lastName);

    List<SupplierContact> findByNit(Long nit);
}