package com.grabandgo.grabandgo_backend.employee.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.employee.domain.Employee;
import java.util.List;

/**
 * EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmail(String email);

    List<Employee> findByEmployees(List<Employee> employees);

    List<Employee> findByExtencion(String extencion);

    List<Employee> findByIdBoss(Long idBoss);

    List<Employee> findByIdOffice(Long idOffice);

    List<Employee> findByName(String name);

    List<Employee> findByLastName1(String lastName1);

    List<Employee> findByLastName2(String lastName2);

    List<Employee> findByPosition(String position);

}