package com.grabandgo.grabandgo_backend.phoneType.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.phoneType.domain.PhoneType;
import com.grabandgo.grabandgo_backend.phoneType.domain.DTO.PhoneTypeDTO;

public interface PhoneTypeService {

    PhoneType savePhoneType(PhoneType phoneType);

    PhoneType updatePhoneType(Long id, PhoneType phoneType);

    void deletePhoneType(Long id);

    PhoneTypeDTO getPhoneTypeById(Long id);

    List<PhoneTypeDTO> fetchPhoneTypesList();

}