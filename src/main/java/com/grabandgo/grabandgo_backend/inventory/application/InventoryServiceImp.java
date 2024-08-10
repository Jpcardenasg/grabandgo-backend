package com.grabandgo.grabandgo_backend.inventory.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.inventory.domain.Inventory;
import com.grabandgo.grabandgo_backend.inventory.infrastructure.adapter.out.InventoryRepository;

/**
 * InventoryServiceImp
 */
@Service
public class InventoryServiceImp implements InventoryService{

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory updateInventory(Long id, Inventory inventory) {
        if(inventoryRepository.existsById(id)){
            inventory.setId(id);
            return inventoryRepository.save(inventory);
        }    else {
            throw new RuntimeException("inventory not found with id: " + id);
        }
    }
    

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<Inventory> findById(Long id) {
        return inventoryRepository.findById(id);
    }

    
}