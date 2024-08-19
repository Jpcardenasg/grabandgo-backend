package com.grabandgo.grabandgo_backend.product.infrastructure.adapter.in;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

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
import com.grabandgo.grabandgo_backend.product.domain.DTO.ProductDTO;

import org.springframework.web.bind.annotation.RequestParam;

@Validated
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody ProductDTO product) {
        Product newProduct = service.convertToEntity(product);
        service.saveProduct(newProduct);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @Valid @RequestBody Product product) {
        service.updateProduct(productId, product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long productId) {
        service.deleteProduct(productId);
        return ResponseEntity.ok(productId);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(service.fetchProductsList());
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Optional<ProductDTO>> getMethodName(@RequestParam Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

}