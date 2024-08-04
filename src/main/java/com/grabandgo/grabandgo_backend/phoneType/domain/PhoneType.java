package com.grabandgo.grabandgo_backend.phoneType.domain;

import java.util.List;

import com.grabandgo.grabandgo_backend.phone.domain.Phone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String phoneType;

    @OneToMany(mappedBy = "phoneType")
    private List<Phone> phones;
}