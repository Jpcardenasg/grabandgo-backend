package com.grabandgo.grabandgo_backend.office.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.office.domain.Office;
import java.util.List;

import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.employee.domain.Employee;

/**
 * OfficeRepository
 */
@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
    List<Office> findByAddress1(String address1);

    List<Office> findByAddress2(String address2);

    List<Office> findByEmployees(List<Employee> employees);

    List<Office> findByCity(City city);

    List<Office> findByPostalCode(String postalCode);
}