package com.grabandgo.grabandgo_backend.orderStatus.domain.DTO;

import java.util.List;

import com.grabandgo.grabandgo_backend.order.domain.Order;
import com.grabandgo.grabandgo_backend.orderStatus.domain.OrderStatus;
import lombok.Data;
/**
 * OrderStatusDTO
 */
@Data
public class OrderStatusDTO {

    private Long id;
    private String name;
    private List<Order> orders;

    public OrderStatusDTO(OrderStatus os) {
        id = os.getId();
        name = os.getName();
        orders = os.getOrders();
    }
}