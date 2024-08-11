package com.grabandgo.grabandgo_backend.paymentMethod.infrastructure.adapter.in;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

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

import com.grabandgo.grabandgo_backend.paymentMethod.application.PaymentMethodService;
import com.grabandgo.grabandgo_backend.paymentMethod.domain.PaymentMethod;

@Validated
@RestController
@RequestMapping("/api/paymentMethod")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService service;

    @PostMapping("/savePaymentMethod")
    public ResponseEntity<PaymentMethod> savePaymentMethod(@Valid @RequestBody PaymentMethod paymentMethod) {
        service.savePaymentMethod(paymentMethod);
        return ResponseEntity.ok(paymentMethod);
    }

    @PutMapping("/updatePaymentMethod/{paymentMethodId}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod(@PathVariable Long paymentMethodId,
            @Valid @RequestBody PaymentMethod paymentMethod) {
        service.updatePaymentMethod(paymentMethodId, paymentMethod);
        return ResponseEntity.ok(paymentMethod);
    }

    @DeleteMapping("/deletePaymentMethod/{paymentMethodId}")
    public ResponseEntity<Long> deletePaymentMethod(@PathVariable Long paymentMethodId) {
        service.deletePaymentMethod(paymentMethodId);
        return ResponseEntity.ok(paymentMethodId);
    }

    @GetMapping("/allPaymentMethods")
    public ResponseEntity<List<PaymentMethod>> findAll() {
        return ResponseEntity.ok(service.fetchPaymentMethodsList());
    }
}