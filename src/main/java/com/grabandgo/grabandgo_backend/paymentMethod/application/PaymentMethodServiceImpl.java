package com.grabandgo.grabandgo_backend.paymentMethod.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.paymentMethod.domain.PaymentMethod;
import com.grabandgo.grabandgo_backend.paymentMethod.domain.DTO.PaymentMethodDTO;
import com.grabandgo.grabandgo_backend.paymentMethod.infrastructure.adapter.out.PaymentMethodRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Transactional
    @Override
    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Transactional
    @Override
    public PaymentMethod updatePaymentMethod(Long id, PaymentMethod paymentMethod) {
        if (paymentMethodRepository.existsById(id)) {
            paymentMethod.setId(id);
            return paymentMethodRepository.save(paymentMethod);
        } else {
            throw new RuntimeException("PaymentMethod not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deletePaymentMethod(Long id) {
        paymentMethodRepository.deleteById(id);
    }

    @Transactional
    @Override
    public PaymentMethodDTO getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Transactional
    @Override
    public List<PaymentMethodDTO> fetchPaymentMethodsList() {
        return paymentMethodRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private PaymentMethodDTO toDto(PaymentMethod paymentMethod) {
        return new PaymentMethodDTO(paymentMethod);
    }

}
