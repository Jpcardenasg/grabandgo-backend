package com.grabandgo.grabandgo_backend.phoneType.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grabandgo.grabandgo_backend.phone.domain.Phone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @JsonManagedReference(value = "phone-phonetype")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "phoneType")
    private List<Phone> phones;
}