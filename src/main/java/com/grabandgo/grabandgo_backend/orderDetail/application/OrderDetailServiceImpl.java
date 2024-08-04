package com.grabandgo.grabandgo_backend.orderDetail.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.orderDetail.domain.ProductOrderPk;
import com.grabandgo.grabandgo_backend.orderDetail.infrastructure.adapter.out.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail updateOrderDetail(ProductOrderPk id, OrderDetail orderDetail) {
        if (orderDetailRepository.existsById(id)) {
            orderDetail.setId(id);
            return orderDetailRepository.save(orderDetail);
        } else {
            throw new RuntimeException("OrderDetail not found with id: " + id);
        }
    }

    @Override
    public void deleteOrderDetail(ProductOrderPk id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public List<OrderDetail> fetchOrderDetailsList() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail getOrderDetailById(ProductOrderPk id) {
        return orderDetailRepository.findById(id).orElse(null);
    }
}
