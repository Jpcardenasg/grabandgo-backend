package com.grabandgo.grabandgo_backend.inventory.domain;

import com.grabandgo.grabandgo_backend.product.domain.Product;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Inventary
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Inventory {

    @Id
    private Long id;
    @Nullable
    private Long minStock;
    private Long maxStock;
    @Nullable
    private Long currentStock;

    @OneToOne
    private Product product;

}