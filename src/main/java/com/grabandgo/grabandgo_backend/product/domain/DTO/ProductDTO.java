package com.grabandgo.grabandgo_backend.product.domain.DTO;

import com.grabandgo.grabandgo_backend.inventory.domain.DTO.InventoryDTO;
import com.grabandgo.grabandgo_backend.orderDetail.domain.DTO.OrderDetailDTO;
import com.grabandgo.grabandgo_backend.productDetail.domain.DTO.ProductDetailDTO;
import com.grabandgo.grabandgo_backend.supplier.domain.DTO.SupplierDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private Long id;
    private String name;
    private Double sellPrice;
    private Double supplierPrice;

    private ProductDetailDTO productDetail;

    private InventoryDTO inventory;

    private SupplierDTO supplier;

    private List<OrderDetailDTO> orderDetails;

}