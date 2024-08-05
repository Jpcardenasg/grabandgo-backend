package com.grabandgo.grabandgo_backend.paymentMethod.domain;

import java.util.List;

import com.grabandgo.grabandgo_backend.payment.domain.Payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String method;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Payment> payment;
}