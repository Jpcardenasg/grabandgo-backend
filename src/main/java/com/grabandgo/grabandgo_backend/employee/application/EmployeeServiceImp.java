package com.grabandgo.grabandgo_backend.employee.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.employee.domain.Employee;
import com.grabandgo.grabandgo_backend.employee.infrastructure.adapter.out.EmployeeRepository;

/**
 * EmployeeServiceImp
 */
@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeToUpdate.setEmail(employee.getEmail());
        employeeToUpdate.setEmployees(employee.getEmployees());
        employeeToUpdate.setExtencion(employee.getExtencion());
        employeeToUpdate.setIdBoss(employee.getIdBoss());
        employeeToUpdate.setIdOffice(employee.getIdOffice());
        employeeToUpdate.setLastName1(employee.getLastName1());
        employeeToUpdate.setLastName2(employee.getLastName2());
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setPosition(employee.getPosition());
        return employeeRepository.save(employeeToUpdate);
    }
}
