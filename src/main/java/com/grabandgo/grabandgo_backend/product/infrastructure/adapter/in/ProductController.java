package com.grabandgo.grabandgo_backend.product.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.product.application.ProductService;
import com.grabandgo.grabandgo_backend.product.domain.Product;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        service.saveProduct(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        service.updateProduct(productId, product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long productId) {
        service.deleteProduct(productId);
        return ResponseEntity.ok(productId);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.fetchProductsList());
    }
}