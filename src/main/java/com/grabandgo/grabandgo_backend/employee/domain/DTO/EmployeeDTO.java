package com.grabandgo.grabandgo_backend.employee.domain.DTO;

import java.util.List;

import com.grabandgo.grabandgo_backend.employee.domain.Employee;

import lombok.Data;

/**
 * EmployeeDTO
 */
@Data
public class EmployeeDTO {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private String extension;
    private String position;
    private List<Employee> employees;
    private String boss;
    private Long office;
    private Long user;

    public EmployeeDTO(Employee employee) {
        id = employee.getId();
        name = employee.getName();
        lastName = employee.getLastName();
        email = employee.getEmail();
        extension = employee.getExtencion();
        position = employee.getPosition();
        employees = employee.getEmployees();
        boss = employee.getBoss().getId();
        office = employee.getOffice().getId();
        user = employee.getUser().getId();
    }
}