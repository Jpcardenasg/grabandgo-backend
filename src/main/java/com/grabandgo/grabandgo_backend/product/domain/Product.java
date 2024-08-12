package com.grabandgo.grabandgo_backend.product.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.productGamma.domain.ProductGamma;
import com.grabandgo.grabandgo_backend.supplier.domain.Supplier;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private Double sellPrice;
    private Double supplierPrice;
    private String img;

    @JsonBackReference(value = "productGamma-product")
    @ManyToOne
    @JoinColumn(name = "productGamaId")
    private ProductGamma productGamma;

    @JsonBackReference(value = "supplier-product")
    @ManyToOne
    @JoinColumn(name = "supplierNit")
    private Supplier supplier;

    @JsonBackReference("details-product")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    @Nullable
    private List<OrderDetail> details;
}