package com.grabandgo.grabandgo_backend.payment.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.payment.domain.Payment;

public interface PaymentService {

    Payment savePayment(Payment payment);

    Payment updatePayment(Long id, Payment payment);

    void deletePayment(Long id);

    Payment getPaymentById(Long id);

    List<Payment> fetchPaymentsList();

}