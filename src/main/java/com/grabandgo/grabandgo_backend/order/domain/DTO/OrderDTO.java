package com.grabandgo.grabandgo_backend.order.domain.DTO;

import java.sql.Date;
import java.util.List;

import com.grabandgo.grabandgo_backend.order.domain.Order;
import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;

import lombok.Data;

/**
 * OrderDTO
 */
@Data
public class OrderDTO {

    private Long id;
    private Date orderDate;
    private Date shippingDate;
    private Date estimatedDeliveryDate;
    private Long status_id;
    private List<OrderDetail> details;
    private String customer_id;

    public OrderDTO(Order order) {
        id = order.getId();
        orderDate = order.getOrderDate();
        shippingDate = order.getShippingDate();
        estimatedDeliveryDate = order.getEstimatedDeliveryDate();
        status_id = order.getStatus().getId();
        details = order.getDetails();
        customer_id = order.getCustomer().getId();
    }
}