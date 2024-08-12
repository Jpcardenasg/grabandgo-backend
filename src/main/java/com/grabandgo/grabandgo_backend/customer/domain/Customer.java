package com.grabandgo.grabandgo_backend.customer.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grabandgo.grabandgo_backend.city.domain.City;
import com.grabandgo.grabandgo_backend.customerContact.domain.CustomerContact;
import com.grabandgo.grabandgo_backend.employee.domain.Employee;
import com.grabandgo.grabandgo_backend.order.domain.Order;
import com.grabandgo.grabandgo_backend.user.domain.User;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    private String id;
    private String name;
    private String lastName;
    private String address;

    private String postalCode;

    @JsonBackReference(value = "city-customers")
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @JsonManagedReference(value = "customers-contact")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    @Builder.Default
    private List<CustomerContact> contactsCustomer = new ArrayList<>();

    @Nullable
    @JsonBackReference(value = "employee-customer")
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @JsonManagedReference(value = "customer-order")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Order> orders;

    @JsonManagedReference("customer-user")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
}