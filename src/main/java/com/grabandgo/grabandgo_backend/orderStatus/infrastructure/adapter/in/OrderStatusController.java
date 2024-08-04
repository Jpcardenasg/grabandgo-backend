package com.grabandgo.grabandgo_backend.orderStatus.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.orderStatus.application.OrderStatusService;
import com.grabandgo.grabandgo_backend.orderStatus.domain.OrderStatus;

@RestController
@RequestMapping("/api/orderStatus")
public class OrderStatusController {

    @Autowired
    private OrderStatusService service;

    @PostMapping("/saveOrderStatus")
    public ResponseEntity<OrderStatus> saveOrderStatus(@RequestBody OrderStatus orderStatus) {
        service.saveOrderStatus(orderStatus);
        return ResponseEntity.ok(orderStatus);
    }

    @PutMapping("/updateOrderStatus/{orderStatusId}")
    public ResponseEntity<OrderStatus> updateOrderStatus(@PathVariable Long orderStatusId,
            @RequestBody OrderStatus orderStatus) {
        service.updateOrderStatus(orderStatusId, orderStatus);
        return ResponseEntity.ok(orderStatus);
    }

    @DeleteMapping("/deleteOrderStatus/{orderStatusId}")
    public ResponseEntity<Long> deleteOrderStatus(@PathVariable Long orderStatusId) {
        service.deleteOrderStatus(orderStatusId);
        return ResponseEntity.ok(orderStatusId);
    }

    @GetMapping("/allOrderStatuses")
    public ResponseEntity<List<OrderStatus>> findAll() {
        return ResponseEntity.ok(service.fetchOrderStatusesList());
    }
}