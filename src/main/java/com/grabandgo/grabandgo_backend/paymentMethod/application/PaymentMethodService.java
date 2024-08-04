package com.grabandgo.grabandgo_backend.paymentMethod.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.paymentMethod.domain.PaymentMethod;

public interface PaymentMethodService {

    PaymentMethod savePaymentMethod(PaymentMethod entity);

    PaymentMethod updatePaymentMethod(Long id, PaymentMethod entity);

    void deletePaymentMethod(Long id);

    PaymentMethod getPaymentMethodById(Long id);

    List<PaymentMethod> fetchPaymentMethodsList();

}