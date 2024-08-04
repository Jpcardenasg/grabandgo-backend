package com.grabandgo.grabandgo_backend.phoneType.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.phoneType.domain.PhoneType;

public interface PhoneTypeService {

    PhoneType savePhoneType(PhoneType phoneType);

    PhoneType updatePhoneType(Long id, PhoneType phoneType);

    void deletePhoneType(Long id);

    PhoneType getPhoneTypeById(Long id);

    List<PhoneType> fetchPhoneTypesList();

}