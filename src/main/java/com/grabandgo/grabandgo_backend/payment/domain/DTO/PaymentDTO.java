package com.grabandgo.grabandgo_backend.payment.domain.DTO;

import java.util.Date;

import com.grabandgo.grabandgo_backend.payment.domain.Payment;

import lombok.Data;

/**
 * PaymentDTO
 */
@Data
public class PaymentDTO {

    private Long id;
    private Date date;
    private Double total;
    private String customer;
    private Long paymentMethod;

    public PaymentDTO(Payment p) {
        id = p.getId();
        date = p.getDate();
        total = p.getTotal();
        customer = p.getCustomer().getId();
        paymentMethod = p.getPaymentMethod().getId();
    }

}