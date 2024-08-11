package com.grabandgo.grabandgo_backend.order.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.order.application.OrderService;
import com.grabandgo.grabandgo_backend.order.domain.Order;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/saveOrder")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        service.saveOrder(order);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/updateOrder/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
        service.updateOrder(orderId, order);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<Long> deleteOrder(@PathVariable Long orderId) {
        service.deleteOrder(orderId);
        return ResponseEntity.ok(orderId);
    }

    @GetMapping("/allOrders")
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}