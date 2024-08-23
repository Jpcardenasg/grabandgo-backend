package com.grabandgo.grabandgo_backend.inventory.infrastructure.adapter.in;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import java.util.List;

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

@Validated
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping("/saveInventory")
    public ResponseEntity<InventoryDTO> saveInventory(@Valid @RequestBody InventoryDTO inventoryDTO) {

        try {
            Inventory inventory = service.toEntity(inventoryDTO);
            service.saveInventory(inventory);
            InventoryDTO response = service.toDTO(inventory);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateInventory/{inventoryId}")
    public ResponseEntity<InventoryDTO> updateInventory(@PathVariable Long inventoryId,
            @Valid @RequestBody InventoryDTO inventoryDTO) {

        try {
            Inventory inventory = service.toEntity(inventoryDTO);
            service.updateInventory(inventoryId, inventory);
            InventoryDTO response = service.toDTO(inventory);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteInventory/{inventoryId}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long inventoryId) {

        try {
            service.deleteInventory(inventoryId);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allInventories")
    public ResponseEntity<List<InventoryDTO>> findAll() {
        try {
            List<Inventory> inventories = service.findAllInventories();
            List<InventoryDTO> inventoryDTOs = inventories.stream()
                    .map(service::toDTO)
                    .toList();

            return new ResponseEntity<>(inventoryDTOs, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getInventory/{id}")
    public ResponseEntity<InventoryDTO> findInventoryById(@PathVariable Long id) {

        try {
            Inventory inventory = service.findInventoryById(id).orElse(null);
            InventoryDTO response = service.toDTO(inventory);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}