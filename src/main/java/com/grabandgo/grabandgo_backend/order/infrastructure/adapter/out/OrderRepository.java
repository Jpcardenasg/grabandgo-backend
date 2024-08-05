package com.grabandgo.grabandgo_backend.order.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.order.domain.Order;
import java.util.List;
import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.orderStatus.domain.OrderStatus;

import java.sql.Date;
import com.grabandgo.grabandgo_backend.customer.domain.Customer;

/**
 * OrderRepository
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByDetails(List<OrderDetail> details);

    List<Order> findByEstimatedDelieryDate(Date estimatedDelieryDate);

    List<Order> findByCustomer(Customer customer);

    List<Order> findByOderDate(Date oderDate);

    List<Order> findByShippingDate(Date shippingDate);

    List<Order> findByStatus(OrderStatus status);

}