package com.grabandgo.grabandgo_backend.employee.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.employee.domain.Employee;
import com.grabandgo.grabandgo_backend.employee.infrastructure.adapter.out.EmployeeRepository;

import jakarta.transaction.Transactional;

/**
 * EmployeeServiceImpl
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee updateEmployee(String id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("employee not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public Optional<Employee> findById(String id) {
        return employeeRepository.findById(id);
    }
}
