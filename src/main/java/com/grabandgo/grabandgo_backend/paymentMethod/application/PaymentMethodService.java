package com.grabandgo.grabandgo_backend.paymentMethod.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.paymentMethod.domain.PaymentMethod;
import com.grabandgo.grabandgo_backend.paymentMethod.domain.DTO.PaymentMethodDTO;

public interface PaymentMethodService {

    PaymentMethod savePaymentMethod(PaymentMethod entity);

    PaymentMethod updatePaymentMethod(Long id, PaymentMethod entity);

    void deletePaymentMethod(Long id);

    PaymentMethodDTO getPaymentMethodById(Long id);

    List<PaymentMethodDTO> fetchPaymentMethodsList();

}