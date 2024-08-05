package com.grabandgo.grabandgo_backend.customer.domain;

import java.util.List;

import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;
import com.grabandgo.grabandgo_backend.order.domain.Order;
import com.grabandgo.grabandgo_backend.phone.domain.Phone;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    private Long id;
    private String name;
    private String lastName;
    private String address1;

    @Nullable
    private String address2;

    private String postalCode;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "customer")
    private List<CustomerContact> contacts;

    @Nullable
    @ManyToOne
    private Long idEmployee;

    @OneToMany(mappedBy = "customer")
    private Phone phone;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}