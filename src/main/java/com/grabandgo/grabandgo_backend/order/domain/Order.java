package com.grabandgo.grabandgo_backend.order.domain;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.orderStatus.domain.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"order\"")
public class Order {

    @Id
    private Long id;
    private Date oderDate;
    private Date shippingDate;
    private Date estimatedDelieryDate;

    @JsonBackReference(value = "oderstastus-order")
    @ManyToOne
    @JoinColumn(name = "orderStatusId")
    private OrderStatus status;

    @JsonManagedReference("order-details")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderDetail> details;

    @JsonBackReference(value = "customer-order")
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}