package com.grabandgo.grabandgo_backend.customer.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.employee.domain.Employee;

import java.util.List;

/**
 * ClientRepository
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findByAddress(String address1);

    List<Customer> findByCity(City city);

    List<Customer> findByEmployee(Employee employee);

    List<Customer> findByName(String name);

    List<Customer> findByPostalCode(String postalCode);
}