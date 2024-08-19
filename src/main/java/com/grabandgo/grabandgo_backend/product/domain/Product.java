package com.grabandgo.grabandgo_backend.product.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grabandgo.grabandgo_backend.inventory.domain.Inventory;
import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.productDetail.domain.ProductDetail;
import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double sellPrice;
    private Double supplierPrice;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private ProductDetail productDetail;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Inventory inventory;

    @JsonBackReference
    @ManyToOne
    private Supplier supplier;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    @Nullable
    private List<OrderDetail> orderDetails;
}