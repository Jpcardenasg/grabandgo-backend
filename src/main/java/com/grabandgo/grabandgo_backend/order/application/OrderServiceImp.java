package com.grabandgo.grabandgo_backend.order.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.order.domain.Order;
import com.grabandgo.grabandgo_backend.order.infrastructure.adapter.out.OrderRepository;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order orderToUpdate = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderToUpdate.setDetails(order.getDetails());
        orderToUpdate.setEstimatedDelieryDate(order.getEstimatedDelieryDate());
        orderToUpdate.setCustomer(order.getCustomer());
        orderToUpdate.setOderDate(order.getOderDate());
        orderToUpdate.setShippingDate(order.getShippingDate());
        orderToUpdate.setStatus(order.getStatus());
        return orderRepository.save(orderToUpdate);
    }

}