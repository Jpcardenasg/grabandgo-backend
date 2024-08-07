package com.grabandgo.grabandgo_backend.phone.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.phone.domain.Phone;

public interface PhoneService {

    Phone savePhone(Phone phone);

    Phone updatePhone(Long id, Phone phone);

    void deletePhone(Long id);

    Phone getPhoneById(Long id);

    List<Phone> fetchPhonesList();
}