package com.grabandgo.grabandgo_backend.orderDetail.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductOrderPk implements Serializable {

    private Long productId;
    private Long orderId;

    @Override
    public int hashCode() {
        return Objects.hash(productId, orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ProductOrderPk that = (ProductOrderPk) obj;
        return Objects.equals(productId, that.productId) && Objects.equals(orderId, that.orderId);
    }
}
