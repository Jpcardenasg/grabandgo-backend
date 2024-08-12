package com.grabandgo.grabandgo_backend.paymentMethod.domain.DTO;

import java.util.ArrayList;
import java.util.List;

import com.grabandgo.grabandgo_backend.payment.domain.Payment;
import com.grabandgo.grabandgo_backend.paymentMethod.domain.PaymentMethod;

import lombok.Data;

/**
 * PaymentTypeDTO
 */
@Data
public class PaymentMethodDTO {
    private Long id;
    private String method;
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private List<Payment> payment = new ArrayList();

    public PaymentMethodDTO(PaymentMethod p) {
        id = p.getId();
        method = p.getMethod();
        payment = p.getPayment();
    }
}