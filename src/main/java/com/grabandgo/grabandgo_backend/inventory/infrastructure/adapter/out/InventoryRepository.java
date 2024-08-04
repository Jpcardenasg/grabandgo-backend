package com.grabandgo.grabandgo_backend.inventory.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabandgo.grabandgo_backend.inventory.domain.Inventory;
import java.util.List;
import com.grabandgo.grabandgo_backend.product.domain.Product;

/**
 * InventaryRepository
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByCurrentStock(Long currentStock);

    List<Inventory> findByMaxStock(Long maxStock);

    List<Inventory> findByMinStock(Long minStock);

    List<Inventory> findByProduct(Product product);
}