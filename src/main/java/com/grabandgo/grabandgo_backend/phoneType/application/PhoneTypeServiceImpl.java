package com.grabandgo.grabandgo_backend.phoneType.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.phoneType.domain.PhoneType;
import com.grabandgo.grabandgo_backend.phoneType.domain.DTO.PhoneTypeDTO;
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
    public PhoneTypeDTO getPhoneTypeById(Long id) {
        return phoneTypeRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Transactional
    @Override
    public List<PhoneTypeDTO> fetchPhoneTypesList() {
        return phoneTypeRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public PhoneTypeDTO toDto(PhoneType pt){
        return new PhoneTypeDTO(pt);
    }

}
