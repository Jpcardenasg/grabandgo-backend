package com.grabandgo.grabandgo_backend.inventory.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.inventory.domain.Inventory;
import com.grabandgo.grabandgo_backend.inventory.domain.DTO.InventoryDTO;
import com.grabandgo.grabandgo_backend.inventory.infrastructure.adapter.out.InventoryRepository;

import jakarta.transaction.Transactional;

/**
 * InventoryServiceImpl
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Transactional
    @Override
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Transactional
    @Override
    public Inventory updateInventory(Long id, Inventory inventory) {
        if (inventoryRepository.existsById(id)) {
            inventory.setId(id);
            return inventoryRepository.save(inventory);
        } else {
            throw new RuntimeException("inventory not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<InventoryDTO> findAll() {
        return inventoryRepository.findAll().stream().map(this::tDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Optional<InventoryDTO> findById(Long id) {
        return inventoryRepository.findById(id).map(this::tDto);
    }

    private InventoryDTO tDto(Inventory inv) {
        return new InventoryDTO(inv);
    }

}