package com.grabandgo.grabandgo_backend.orderDetail.application;

import java.util.List;
import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.orderDetail.domain.ProductOrderPk;

public interface OrderDetailService {

    OrderDetail saveOrderDetail(OrderDetail orderDetail);

    OrderDetail updateOrderDetail(ProductOrderPk id, OrderDetail orderDetail);

    void deleteOrderDetail(ProductOrderPk id);

    OrderDetail getOrderDetailById(ProductOrderPk id);

    List<OrderDetail> fetchOrderDetailsList();
}
