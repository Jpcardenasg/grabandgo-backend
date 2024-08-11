package com.grabandgo.grabandgo_backend.payment.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.payment.domain.Payment;
import com.grabandgo.grabandgo_backend.payment.infrastructure.adapter.out.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Transactional
    @Override
    public Payment updatePayment(Long id, Payment payment) {
        if (paymentRepository.existsById(id)) {
            payment.setId(id);
            return paymentRepository.save(payment);
        } else {
            throw new RuntimeException("Payment not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<Payment> fetchPaymentsList() {
        return paymentRepository.findAll();
    }

}