package com.grabandgo.grabandgo_backend.inventory.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {

    private Long id;
    private Long minStock;
    private Long maxStock;
    private Long currentStock;
    private Long productId;

}