package com.grabandgo.grabandgo_backend.office.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.office.domain.Office;
import com.grabandgo.grabandgo_backend.office.infrastructure.adapter.out.OfficeRepository;

import jakarta.transaction.Transactional;

/**
 * OfficeServiceImpl
 */
@Service
public class OfficeServiceImpl implements OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    @Transactional
    @Override
    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<Office> findAll() {
        return officeRepository.findAll();
    }

    @Transactional
    @Override
    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    @Transactional
    @Override
    public Office updateOffice(Long id, Office office) {
        if (officeRepository.existsById(id)) {
            office.setId(id);
            return officeRepository.save(office);
        } else {
            throw new RuntimeException("office not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public Optional<Office> findById(Long id) {
        return officeRepository.findById(id);
    }
}