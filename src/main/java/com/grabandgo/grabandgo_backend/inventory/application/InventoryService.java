package com.grabandgo.grabandgo_backend.inventory.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.inventory.domain.Inventory;
import com.grabandgo.grabandgo_backend.inventory.domain.DTO.InventoryDTO;

public interface InventoryService {

    void saveInventory(Inventory inventory);

    void updateInventory(Long id, Inventory inventory);

    void deleteInventory(Long id);

    List<Inventory> findAll();

    Optional<Inventory> findById(Long id);

    InventoryDTO convertToDTO(Inventory inventory);

    Inventory convertToEntity(InventoryDTO inventoryDTO);
}