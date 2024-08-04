package com.grabandgo.grabandgo_backend.phoneType.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.phoneType.domain.PhoneType;
import com.grabandgo.grabandgo_backend.phoneType.infrastructure.adapter.out.PhoneTypeRepository;

@Service
public class PhoneTypeServiceImpl implements PhoneTypeService {

    @Autowired
    private PhoneTypeRepository phoneTypeRepository;

    @Override
    public PhoneType savePhoneType(PhoneType phoneType) {
        return phoneTypeRepository.save(phoneType);
    }

    @Override
    public PhoneType updatePhoneType(Long id, PhoneType phoneType) {
        if (phoneTypeRepository.existsById(id)) {
            phoneType.setId(id);
            return phoneTypeRepository.save(phoneType);
        } else {
            throw new RuntimeException("PhoneType not found with id: " + id);
        }
    }

    @Override
    public void deletePhoneType(Long id) {
        phoneTypeRepository.deleteById(id);
    }

    @Override
    public PhoneType getPhoneTypeById(Long id) {
        return phoneTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<PhoneType> fetchPhoneTypesList() {
        return phoneTypeRepository.findAll();
    }

}
