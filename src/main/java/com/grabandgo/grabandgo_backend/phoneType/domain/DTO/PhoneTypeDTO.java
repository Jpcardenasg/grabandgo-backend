package com.grabandgo.grabandgo_backend.phoneType.domain.DTO;

import java.util.List;

import com.grabandgo.grabandgo_backend.phone.domain.Phone;
import com.grabandgo.grabandgo_backend.phoneType.domain.PhoneType;

import lombok.Data;

/**
 * PhoneTypeDTO
 */
@Data
public class PhoneTypeDTO {
    private Long id;
    private String phoneType;
    private List<Phone> phones;

    public PhoneTypeDTO(PhoneType p) {
        id = p.getId();
        phoneType = p.getPhoneType();
        phones = p.getPhones();
    }
}