package com.grabandgo.grabandgo_backend.phoneType.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.phoneType.domain.PhoneType;
import com.grabandgo.grabandgo_backend.phoneType.infrastructure.adapter.out.PhoneTypeRepository;

import jakarta.transaction.Transactional;

@Service
public class PhoneTypeServiceImpl implements PhoneTypeService {

    @Autowired
    private PhoneTypeRepository phoneTypeRepository;

    @Transactional
    @Override
    public PhoneType savePhoneType(PhoneType phoneType) {
        return phoneTypeRepository.save(phoneType);
    }

    @Transactional
    @Override
    public PhoneType updatePhoneType(Long id, PhoneType phoneType) {
        if (phoneTypeRepository.existsById(id)) {
            phoneType.setId(id);
            return phoneTypeRepository.save(phoneType);
        } else {
            throw new RuntimeException("PhoneType not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deletePhoneType(Long id) {
        phoneTypeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public PhoneType getPhoneTypeById(Long id) {
        return phoneTypeRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<PhoneType> fetchPhoneTypesList() {
        return phoneTypeRepository.findAll();
    }

}
