package com.grabandgo.grabandgo_backend.inventory.application;

import com.grabandgo.grabandgo_backend.inventory.domain.DTO.InventoryDTO;
import com.grabandgo.grabandgo_backend.inventory.domain.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {

    void saveInventory(Inventory inventory);

    void updateInventory(Long id, Inventory inventory);

    void deleteInventory(Long id);

    List<Inventory> findAllInventories();

    Optional<Inventory> findInventoryById(Long id);

    InventoryDTO toDTO(Inventory inventory);

    Inventory toEntity(InventoryDTO inventoryDTO);
}