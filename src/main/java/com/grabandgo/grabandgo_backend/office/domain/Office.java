package com.grabandgo.grabandgo_backend.office.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.employee.domain.Employee;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Office
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Office {

    @Id
    private Long id;
    private String postalCode;
    private String address1;
    private String address2;

    @JsonManagedReference(value = "employee-office")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "office")
    private List<Employee> employees;

    @JsonBackReference("city-offices")
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;
}