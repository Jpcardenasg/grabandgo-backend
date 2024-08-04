package com.grabandgo.grabandgo_backend.paymentMethod.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.paymentMethod.domain.PaymentMethod;
import com.grabandgo.grabandgo_backend.paymentMethod.infrastructure.adapter.out.PaymentMethodRepository;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod updatePaymentMethod(Long id, PaymentMethod paymentMethod) {
        if (paymentMethodRepository.existsById(id)) {
            paymentMethod.setId(id);
            return paymentMethodRepository.save(paymentMethod);
        } else {
            throw new RuntimeException("PaymentMethod not found with id: " + id);
        }
    }

    @Override
    public void deletePaymentMethod(Long id) {
        paymentMethodRepository.deleteById(id);
    }

    @Override
    public PaymentMethod getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id).orElse(null);
    }

    @Override
    public List<PaymentMethod> fetchPaymentMethodsList() {
        return paymentMethodRepository.findAll();
    }

}
