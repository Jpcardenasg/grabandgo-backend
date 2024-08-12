package com.grabandgo.grabandgo_backend.orderStatus.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.orderStatus.domain.OrderStatus;
import com.grabandgo.grabandgo_backend.orderStatus.domain.DTO.OrderStatusDTO;

public interface OrderStatusService {

    OrderStatus saveOrderStatus(OrderStatus orderStatus);

    OrderStatus updateOrderStatus(Long id, OrderStatus orderStatus);

    void deleteOrderStatus(Long id);

    OrderStatusDTO getOrderStatusById(Long id);

    List<OrderStatusDTO> fetchOrderStatusesList();

}