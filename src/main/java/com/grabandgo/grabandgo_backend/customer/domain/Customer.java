package com.grabandgo.grabandgo_backend.customer.domain;

import java.util.List;

import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;
import com.grabandgo.grabandgo_backend.employee.domain.Employee;
import com.grabandgo.grabandgo_backend.order.domain.Order;
import com.grabandgo.grabandgo_backend.user.domain.User;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    private String id;
    private String name;
    private String lastName;
    private String address1;

    private String postalCode;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "customer")
    private List<CustomerContact> contactsCustomer;

    @Nullable
    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @OneToOne
    private User user;
}