package com.grabandgo.grabandgo_backend.city.domain;

import java.util.List;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * City
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City {

    @Id
    private Long Id;
    private String Name;
    @ManyToOne
    private Long regionId;
    @OneToMany(mappedBy = "idCity")
    private List<Customer> customers;
}