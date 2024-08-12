package com.grabandgo.grabandgo_backend.employee.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.employee.domain.Employee;
import com.grabandgo.grabandgo_backend.employee.domain.DTO.EmployeeDTO;

/**
 * EmployeeService
 */
public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Employee updateEmployee(String id, Employee employee);

    void deleteEmployee(String id);

    List<EmployeeDTO> findAll();

    Optional<EmployeeDTO> findById(String id);
}