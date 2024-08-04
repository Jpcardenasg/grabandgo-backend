package com.grabandgo.grabandgo_backend.orderDetail.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.orderDetail.domain.ProductOrderPk;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, ProductOrderPk> {

}