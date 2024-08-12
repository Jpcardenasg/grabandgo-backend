package com.grabandgo.grabandgo_backend.orderDetail.application;

import java.util.List;
import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.orderDetail.domain.ProductOrderPk;
import com.grabandgo.grabandgo_backend.orderDetail.domain.DTO.OrderDetailDTO;

public interface OrderDetailService {

    OrderDetail saveOrderDetail(OrderDetail orderDetail);

    OrderDetail updateOrderDetail(ProductOrderPk id, OrderDetail orderDetail);

    void deleteOrderDetail(ProductOrderPk id);

    OrderDetailDTO getOrderDetailById(ProductOrderPk id);

    List<OrderDetailDTO> fetchOrderDetailsList();
}
