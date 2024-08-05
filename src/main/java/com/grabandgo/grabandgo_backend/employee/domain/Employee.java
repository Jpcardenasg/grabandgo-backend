package com.grabandgo.grabandgo_backend.employee.domain;

import java.util.List;

import com.grabandgo.grabandgo_backend.office.domain.Office;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Employee
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    private Long id;
    private String name;
    private String lastName1;
    @Nullable
    private String lastName2;
    private String email;
    private String extencion;
    @Nullable
    private String position;

    @OneToMany(mappedBy = "boss")
    private List<Employee> employees;

    @ManyToOne
    private Employee boss;

    @ManyToOne
    private Office office;
}