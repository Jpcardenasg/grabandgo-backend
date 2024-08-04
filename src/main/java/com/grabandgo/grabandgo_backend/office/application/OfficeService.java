package com.grabandgo.grabandgo_backend.office.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.office.domain.Office;

/**
 * OfficeService
 */
public interface OfficeService {
    Office saveOffice(Office office);

    Office updateOffice(Long id, Office office);

    void deleteOffice(Long id);

    List<Office> findAll();

}