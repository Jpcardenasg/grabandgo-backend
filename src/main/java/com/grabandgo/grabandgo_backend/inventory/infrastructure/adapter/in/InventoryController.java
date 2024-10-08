package com.grabandgo.grabandgo_backend.inventory.infrastructure.adapter.in;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grabandgo.grabandgo_backend.inventory.application.InventoryService;
import com.grabandgo.grabandgo_backend.inventory.domain.Inventory;
import com.grabandgo.grabandgo_backend.inventory.domain.DTO.InventoryDTO;

/**
 * InventaryAdapter
 */
@Validated
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService service;

    @PostMapping("/saveInventory")
    public ResponseEntity<Inventory> saveInventory(@Valid @RequestBody Inventory inventory) {
        service.saveInventory(inventory);
        return ResponseEntity.ok(inventory);
    }

    @PutMapping("/updateInventory/{inventoryId}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Long inventoryId,
            @Valid @RequestBody Inventory inventory) {
        service.updateInventory(inventoryId, inventory);
        return ResponseEntity.ok(inventory);
    }

    @DeleteMapping("/deleteInventory/{inventoryId}")
    public ResponseEntity<Long> deleteInventory(@PathVariable Long inventoryId) {
        service.deleteInventory(inventoryId);
        return ResponseEntity.ok(inventoryId);
    }

    @GetMapping("/allInventories")
    public ResponseEntity<List<InventoryDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/getInvetory/{id}")
    public ResponseEntity<InventoryDTO> getInvetoryByid(@PathVariable Long id) {
        return ResponseEntity.of(service.findById(id));
    }
}