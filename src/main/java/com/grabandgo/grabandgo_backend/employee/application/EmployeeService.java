package com.grabandgo.grabandgo_backend.employee.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.employee.domain.Employee;

/**
 * EmployeeService
 */
public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Employee updateEmployee(String id, Employee employee);

    void deleteEmployee(String id);

    List<Employee> findAll();

    Optional<Employee> findById(String id);
}