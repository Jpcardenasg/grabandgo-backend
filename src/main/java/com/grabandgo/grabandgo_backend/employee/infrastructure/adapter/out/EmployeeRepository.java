package com.grabandgo.grabandgo_backend.employee.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.employee.domain.Employee;
import com.grabandgo.grabandgo_backend.office.domain.Office;

import java.util.List;

/**
 * EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByEmail(String email);

    List<Employee> findByEmployees(List<Employee> employees);

    List<Employee> findByExtencion(String extencion);

    List<Employee> findByBoss(Employee boss);

    List<Employee> findByOffice(Office office);

    List<Employee> findByName(String name);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByPosition(String position);

}