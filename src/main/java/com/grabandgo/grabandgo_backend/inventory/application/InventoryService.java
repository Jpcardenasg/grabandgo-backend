package com.grabandgo.grabandgo_backend.inventory.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.inventory.domain.Inventory;
import com.grabandgo.grabandgo_backend.inventory.domain.DTO.InventoryDTO;

/**
 * InventaryService
 */
public interface InventoryService {

    Inventory saveInventory(Inventory inventory);

    Inventory updateInventory(Long id, Inventory inventory);

    void deleteInventory(Long id);

    List<InventoryDTO> findAll();

    Optional<InventoryDTO> findById(Long id);
}