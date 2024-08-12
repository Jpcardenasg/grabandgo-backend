package com.grabandgo.grabandgo_backend.inventory.domain.DTO;

import com.grabandgo.grabandgo_backend.inventory.domain.Inventory;
import com.grabandgo.grabandgo_backend.product.domain.Product;

/**
 * InventaryDTO
 */
public class InventoryDTO {

    private Long id;
    private Long minStock;
    private Long maxStock;
    private Long currentStock;
    private Long product_id;

    public InventoryDTO(Inventory inv) {
        id = inv.getId();
        minStock = inv.getMinStock();
        maxStock = inv.getMaxStock();
        currentStock = inv.getCurrentStock();
        product_id = inv.getProduct().getId();
    }
}