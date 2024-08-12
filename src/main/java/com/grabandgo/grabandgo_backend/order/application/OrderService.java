package com.grabandgo.grabandgo_backend.order.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.order.domain.Order;
import com.grabandgo.grabandgo_backend.order.domain.DTO.OrderDTO;

/**
 * OrderService
 */
public interface OrderService {

    Order saveOrder(Order order);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);

    List<OrderDTO> findAll();

    Optional<OrderDTO> findById(Long id);

}