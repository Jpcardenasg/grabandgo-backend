package com.grabandgo.grabandgo_backend.product.domain.DTO;

import java.util.List;

import com.grabandgo.grabandgo_backend.orderDetail.domain.OrderDetail;
import com.grabandgo.grabandgo_backend.product.domain.Product;

import lombok.Data;

/**
 * ProductDTO
 */
@Data
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double sellPrice;
    private Double supplierPrice;
    private String img;
    private Long productGamma_id;
    private String supplier_nit;
    private List<OrderDetail> details;

    public ProductDTO(Product p) {
        id = p.getId();
        name = p.getName();
        description = p.getDescription();
        sellPrice = p.getSellPrice();
        supplierPrice = p.getSupplierPrice();
        img = p.getImg();
        productGamma_id = p.getProductGamma().getId();
        supplier_nit = p.getSupplier().getNit();
        details = p.getDetails();
    }
}