package com.grabandgo.grabandgo_backend.orderStatus.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.orderStatus.domain.OrderStatus;
import com.grabandgo.grabandgo_backend.orderStatus.infrastructure.adapter.out.OrderStatusRepository;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Override
    public OrderStatus saveOrderStatus(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus updateOrderStatus(Long id, OrderStatus orderStatus) {
        if (orderStatusRepository.existsById(id)) {
            orderStatus.setId(id);
            return orderStatusRepository.save(orderStatus);
        } else {
            throw new RuntimeException("OrderStatus not found with id: " + id);
        }
    }

    @Override
    public void deleteOrderStatus(Long id) {
        orderStatusRepository.deleteById(id);
    }

    @Override
    public List<OrderStatus> fetchOrderStatusesList() {
        return orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus getOrderStatusById(Long id) {
        return orderStatusRepository.findById(id).orElse(null);
    }
}
