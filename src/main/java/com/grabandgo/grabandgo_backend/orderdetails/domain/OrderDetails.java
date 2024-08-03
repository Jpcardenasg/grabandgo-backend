package com.grabandgo.grabandgo_backend.orderdetails.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderDetails {

    private Long quantity;
    private Double price;
    private Integer lineNumber;

}