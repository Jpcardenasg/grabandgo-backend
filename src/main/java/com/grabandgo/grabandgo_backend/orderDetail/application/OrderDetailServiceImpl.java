package com.grabandgo.grabandgo_backend.orderDetail.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.orderDetail.domain.ProductOrderPk;
import com.grabandgo.grabandgo_backend.orderDetail.domain.DTO.OrderDetailDTO;
import com.grabandgo.grabandgo_backend.orderDetail.infrastructure.adapter.out.OrderDetailRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Transactional
    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Transactional
    @Override
    public OrderDetail updateOrderDetail(ProductOrderPk id, OrderDetail orderDetail) {
        if (orderDetailRepository.existsById(id)) {
            orderDetail.setId(id);
            return orderDetailRepository.save(orderDetail);
        } else {
            throw new RuntimeException("OrderDetail not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteOrderDetail(ProductOrderPk id) {
        orderDetailRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<OrderDetailDTO> fetchOrderDetailsList() {
        return orderDetailRepository.findAll().stream().map(this::tDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public OrderDetailDTO getOrderDetailById(ProductOrderPk id) {
        return orderDetailRepository.findById(id).map(this::tDto).orElse(null);
    }

    private OrderDetailDTO tDto(OrderDetail od) {
        return new OrderDetailDTO(od);
    }
}
