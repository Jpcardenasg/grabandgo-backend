package com.grabandgo.grabandgo_backend.payment.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.payment.domain.Payment;
import com.grabandgo.grabandgo_backend.payment.domain.DTO.PaymentDTO;

public interface PaymentService {

    Payment savePayment(Payment payment);

    Payment updatePayment(Long id, Payment payment);

    void deletePayment(Long id);

    Optional<PaymentDTO> getPaymentById(Long id);

    List<PaymentDTO> fetchPaymentsList();

}