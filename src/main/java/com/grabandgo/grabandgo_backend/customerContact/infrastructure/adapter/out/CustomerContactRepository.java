package com.grabandgo.grabandgo_backend.customerContact.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;

import java.util.List;

/**
 * ContactRepository
 */
@Repository
public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {

    List<CustomerContact> findByCustomer(Customer customer);

}