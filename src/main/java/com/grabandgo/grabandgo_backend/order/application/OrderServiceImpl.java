package com.grabandgo.grabandgo_backend.order.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.order.domain.Order;
import com.grabandgo.grabandgo_backend.order.domain.DTO.OrderDTO;
import com.grabandgo.grabandgo_backend.order.infrastructure.adapter.out.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Optional<OrderDTO> findById(Long id) {
        return orderRepository.findById(id).map(this::toDto);
    }

    @Transactional
    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    @Override
    public Order updateOrder(Long id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("order not found with id: " + id);
        }
    }

    private OrderDTO toDto(Order odrer) {
        return new OrderDTO(odrer);
    }

}