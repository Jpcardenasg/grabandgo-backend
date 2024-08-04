package com.grabandgo.grabandgo_backend.office.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.office.domain.Office;
import com.grabandgo.grabandgo_backend.office.infrastructure.adapter.out.OfficeRepository;

/**
 * OfficeServiceImp
 */
@Service
public class OfficeServiceImp implements OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }

    @Override
    public List<Office> findAll() {
        return officeRepository.findAll();
    }

    @Override
    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public Office updateOffice(Long id, Office office) {
        Office officeToUpdate = officeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Office not found"));
        officeToUpdate.setAddress1(office.getAddress1());
        officeToUpdate.setAddress2(office.getAddress2());
        officeToUpdate.setPostalCode(office.getPostalCode());
        officeToUpdate.setEmployees(office.getEmployees());
        officeToUpdate.setIdCity(office.getIdCity());
        return officeRepository.save(officeToUpdate);
    }
}