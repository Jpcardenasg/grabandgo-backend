package com.grabandgo.grabandgo_backend.inventory.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.inventory.domain.Inventory;

/**
 * InventaryService
 */
public interface InventoryService {

    Inventory saveInventory(Inventory inventory);

    Inventory updateInventory(Long id, Inventory inventory);

    void deleteInventory(Long id);

    List<Inventory> findAll();
}