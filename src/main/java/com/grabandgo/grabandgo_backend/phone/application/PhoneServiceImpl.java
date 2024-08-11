package com.grabandgo.grabandgo_backend.phone.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.phone.domain.Phone;
import com.grabandgo.grabandgo_backend.phone.infrastructure.adapter.out.PhoneRepository;

import jakarta.transaction.Transactional;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Transactional
    @Override
    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Transactional
    @Override
    public Phone updatePhone(Long id, Phone phone) {
        if (phoneRepository.existsById(id)) {
            phone.setId(id);
            return phoneRepository.save(phone);
        } else {
            throw new RuntimeException("Phone not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<Phone> fetchPhonesList() {
        return phoneRepository.findAll();
    }

}