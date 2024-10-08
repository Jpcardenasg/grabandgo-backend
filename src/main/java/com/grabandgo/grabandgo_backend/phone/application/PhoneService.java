package com.grabandgo.grabandgo_backend.phone.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.phone.domain.Phone;
import com.grabandgo.grabandgo_backend.phone.domain.DTO.PhoneDTO;

public interface PhoneService {

    Phone savePhone(Phone phone);

    Phone updatePhone(Long id, Phone phone);

    void deletePhone(Long id);

    PhoneDTO getPhoneById(Long id);

    List<PhoneDTO> fetchPhonesList();
}