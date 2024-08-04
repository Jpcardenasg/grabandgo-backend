package com.grabandgo.grabandgo_backend.customer.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import java.util.List;

/**
 * ClientRepository
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByAddress1(String address1);

    List<Customer> findByAddress2(String address2);

    List<Customer> findByIdCity(Long idCity);

    List<Customer> findByIdEmployee(Long idEmployee);

    List<Customer> findByName(String name);

    List<Customer> findByPostalCode(String postalCode);
}