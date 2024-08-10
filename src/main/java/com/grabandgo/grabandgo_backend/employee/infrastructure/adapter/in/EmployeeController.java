package com.grabandgo.grabandgo_backend.employee.infrastructure.adapter.in;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grabandgo.grabandgo_backend.employee.application.EmployeeService;
import com.grabandgo.grabandgo_backend.employee.domain.Employee;

/**
 * EmployeeAdapter
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/updateEmployee/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String employeeId, @RequestBody Employee employee) {
        service.updateEmployee(employeeId, employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId) {
        service.deleteEmployee(employeeId);
        return ResponseEntity.ok(employeeId);
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeByid(@PathVariable String id) {
        return ResponseEntity.of(service.findById(id));
    }
}