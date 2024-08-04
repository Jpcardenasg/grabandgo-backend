package com.grabandgo.grabandgo_backend.phoneType.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.phoneType.domain.PhoneType;

@Repository
public interface PhoneTypeRepository extends JpaRepository<PhoneType, Long> {
}