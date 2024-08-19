package com.grabandgo.grabandgo_backend.orderDetail.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grabandgo.grabandgo_backend.order.domain.Order;
import com.grabandgo.grabandgo_backend.product.domain.Product;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    @EmbeddedId
    private ProductOrderPk id;
    private Long quantity;
    private Double unitPrice;
    private Integer lineNumber;

    @JsonBackReference
    @ManyToOne
    private Product product;

    @JsonBackReference
    @ManyToOne
    private Order order;

}