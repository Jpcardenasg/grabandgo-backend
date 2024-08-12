package com.grabandgo.grabandgo_backend.payment.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.payment.domain.Payment;
import com.grabandgo.grabandgo_backend.payment.domain.DTO.PaymentDTO;
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
    public Optional<PaymentDTO> getPaymentById(Long id) {
        return paymentRepository.findById(id).map(this::toDto);
    }

    @Transactional
    @Override
    public List<PaymentDTO> fetchPaymentsList() {
        return paymentRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private PaymentDTO toDto(Payment payment) {
        return new PaymentDTO(payment);
    }

}