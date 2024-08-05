package com.grabandgo.grabandgo_backend.office.domain;

import java.util.List;

import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.employee.domain.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @OneToMany(mappedBy = "office")
    private List<Employee> employees;

    @ManyToOne
    private City city;
}