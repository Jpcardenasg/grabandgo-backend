package com.grabandgo.grabandgo_backend.order.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.order.domain.Order;
import java.util.List;
import com.grabandgo.grabandgo_backend.orderdetails.domain.OrderDetails;
import java.sql.Date;
import com.grabandgo.grabandgo_backend.customer.domain.Customer;
import com.grabandgo.grabandgo_backend.orderstatus.domain.OrderStatus;

/**
 * OrderRepository
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByDetails(List<OrderDetails> details);

    List<Order> findByEstimatedDelieryDate(Date estimatedDelieryDate);

    List<Order> findByIdCustomer(Customer idCustomer);

    List<Order> findByOderDate(Date oderDate);

    List<Order> findByShippingDate(Date shippingDate);

    List<Order> findByStatus(OrderStatus status);

}