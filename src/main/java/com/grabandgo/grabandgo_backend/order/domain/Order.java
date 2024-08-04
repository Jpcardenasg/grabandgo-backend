package com.grabandgo.grabandgo_backend.order.domain;

import java.sql.Date;
import java.util.List;

import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.orderStatus.domain.OrderStatus;

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
public class Order {

    @Id
    private Long id;
    private Date oderDate;
    private Date shippingDate;
    private Date estimatedDelieryDate;

    @ManyToOne
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> details;

    @ManyToOne
    private Customer customer;

}