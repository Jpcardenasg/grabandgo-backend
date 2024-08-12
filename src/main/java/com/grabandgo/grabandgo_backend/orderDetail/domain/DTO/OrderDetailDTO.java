package com.grabandgo.grabandgo_backend.orderDetail.domain.DTO;

import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.orderDetail.domain.ProductOrderPk;

import lombok.Data;

/**
 * OrderDetailsDTO
 */
@Data
public class OrderDetailDTO {

    private ProductOrderPk id;
    private Long product;
    private Long order;
    private Long quantity;
    private Double unitPrice;
    private Integer lineNumber;

    public OrderDetailDTO(OrderDetail od) {
        id = od.getId();
        product = od.getProduct().getId();
        order = od.getOrder().getId();
        quantity = od.getQuantity();
        unitPrice = od.getUnitPrice();
        lineNumber = od.getLineNumber();
    }
}