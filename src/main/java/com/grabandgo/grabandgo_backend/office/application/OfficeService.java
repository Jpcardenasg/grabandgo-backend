package com.grabandgo.grabandgo_backend.office.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.office.domain.Office;
import com.grabandgo.grabandgo_backend.office.domain.DTO.OfficeDTO;

/**
 * OfficeService
 */
public interface OfficeService {
    Office saveOffice(Office office);

    Office updateOffice(Long id, Office office);

    void deleteOffice(Long id);

    List<OfficeDTO> findAll();

    Optional<OfficeDTO> findById(Long id);
}