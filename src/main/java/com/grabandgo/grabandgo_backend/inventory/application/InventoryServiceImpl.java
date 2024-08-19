package com.grabandgo.grabandgo_backend.inventory.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.product.domain.Product;
import com.grabandgo.grabandgo_backend.product.infrastructure.adapter.out.ProductRepository;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.inventory.domain.Inventory;
import com.grabandgo.grabandgo_backend.inventory.domain.DTO.InventoryDTO;
import com.grabandgo.grabandgo_backend.inventory.infrastructure.adapter.out.InventoryRepository;

import jakarta.transaction.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, ProductRepository productRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public void saveInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Transactional
    @Override
    public void updateInventory(Long id, Inventory inventory) {
        if (inventoryRepository.existsById(id)) {
            inventory.setId(id);
            inventoryRepository.save(inventory);
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
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Inventory> findById(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public InventoryDTO convertToDTO(Inventory inventory) {

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setId(inventory.getId());
        inventoryDTO.setMinStock(inventory.getMinStock());
        inventoryDTO.setMaxStock(inventory.getMaxStock());
        inventoryDTO.setCurrentStock(inventory.getCurrentStock());
        inventoryDTO.setProductId(inventory.getProduct().getId());

        return inventoryDTO;
    }

    @Override
    public Inventory convertToEntity(InventoryDTO inventoryDTO) {

        Inventory inventory = new Inventory();
        inventory.setId(inventoryDTO.getId());
        inventory.setMinStock(inventoryDTO.getMinStock());
        inventory.setMaxStock(inventoryDTO.getMaxStock());
        inventory.setCurrentStock(inventoryDTO.getCurrentStock());

        Product product = productRepository.findById(inventoryDTO.getProductId()).orElse(null);
        inventory.setProduct(product);

        return inventory;
    }

}