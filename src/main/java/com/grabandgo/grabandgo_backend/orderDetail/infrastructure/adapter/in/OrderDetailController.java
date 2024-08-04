package com.grabandgo.grabandgo_backend.orderDetail.infrastructure.adapter.in;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grabandgo.grabandgo_backend.orderDetail.application.OrderDetailService;
import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.orderDetail.domain.ProductOrderPk;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService service;

    @PostMapping("/saveOrderDetail")
    public ResponseEntity<OrderDetail> saveOrderDetail(@RequestBody OrderDetail orderDetail) {
        service.saveOrderDetail(orderDetail);
        return ResponseEntity.ok(orderDetail);
    }

    @PutMapping("/updateOrderDetail/{orderDetailId}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable ProductOrderPk orderDetailId,
            @RequestBody OrderDetail orderDetail) {
        service.updateOrderDetail(orderDetailId, orderDetail);
        return ResponseEntity.ok(orderDetail);
    }

    @DeleteMapping("/deleteOrderDetail/{orderDetailId}")
    public ResponseEntity<ProductOrderPk> deleteOrderDetail(@PathVariable ProductOrderPk orderDetailId) {
        service.deleteOrderDetail(orderDetailId);
        return ResponseEntity.ok(orderDetailId);
    }

    @GetMapping("/allOrderDetails")
    public ResponseEntity<List<OrderDetail>> findAll() {
        return ResponseEntity.ok(service.fetchOrderDetailsList());
    }
}