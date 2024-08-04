package com.grabandgo.grabandgo_backend.payment.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.payment.application.PaymentService;
import com.grabandgo.grabandgo_backend.payment.domain.Payment;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/savePayment")
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
        service.savePayment(payment);
        return ResponseEntity.ok(payment);
    }

    @PutMapping("/updatePayment/{paymentId}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long paymentId, @RequestBody Payment payment) {
        service.updatePayment(paymentId, payment);
        return ResponseEntity.ok(payment);
    }

    @DeleteMapping("/deletePayment/{paymentId}")
    public ResponseEntity<Long> deletePayment(@PathVariable Long paymentId) {
        service.deletePayment(paymentId);
        return ResponseEntity.ok(paymentId);
    }

    @GetMapping("/allPayments")
    public ResponseEntity<List<Payment>> findAll() {
        return ResponseEntity.ok(service.fetchPaymentsList());
    }
}