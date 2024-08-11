package com.grabandgo.grabandgo_backend.paymentMethod.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.paymentMethod.domain.PaymentMethod;
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
    public PaymentMethod getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<PaymentMethod> fetchPaymentMethodsList() {
        return paymentMethodRepository.findAll();
    }

}
