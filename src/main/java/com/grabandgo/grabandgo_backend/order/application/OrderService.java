package com.grabandgo.grabandgo_backend.order.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.order.domain.Order;

/**
 * OrderService
 */
public interface OrderService {

    Order saveOrder(Order order);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);

    List<Order> findAll();

}