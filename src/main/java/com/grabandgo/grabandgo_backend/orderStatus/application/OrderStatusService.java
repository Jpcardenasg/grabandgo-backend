package com.grabandgo.grabandgo_backend.orderStatus.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.orderStatus.domain.OrderStatus;

public interface OrderStatusService {

    OrderStatus saveOrderStatus(OrderStatus orderStatus);

    OrderStatus updateOrderStatus(Long id, OrderStatus orderStatus);

    void deleteOrderStatus(Long id);

    OrderStatus getOrderStatusById(Long id);

    List<OrderStatus> fetchOrderStatusesList();

}