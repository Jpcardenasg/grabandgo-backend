package com.grabandgo.grabandgo_backend.productGamma.infrastructure.adapter.in;

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

import com.grabandgo.grabandgo_backend.productGamma.application.ProductGammaService;
import com.grabandgo.grabandgo_backend.productGamma.domain.ProductGamma;

@RestController
@RequestMapping("/api/productGamma")
public class ProductGammaController {

    @Autowired
    private ProductGammaService service;

    @PostMapping("/saveProductGamma")
    public ResponseEntity<ProductGamma> saveProductGamma(@RequestBody ProductGamma productGamma) {
        service.saveProductGamma(productGamma);
        return ResponseEntity.ok(productGamma);
    }

    @PutMapping("/updateProductGamma/{productGammaId}")
    public ResponseEntity<ProductGamma> updateProductGamma(@PathVariable Long productGammaId,
            @RequestBody ProductGamma productGamma) {
        service.updateProductGamma(productGammaId, productGamma);
        return ResponseEntity.ok(productGamma);
    }

    @DeleteMapping("/deleteProductGamma/{productGammaId}")
    public ResponseEntity<Long> deleteProductGamma(@PathVariable Long productGammaId) {
        service.deleteProductGamma(productGammaId);
        return ResponseEntity.ok(productGammaId);
    }

    @GetMapping("/allProductGammas")
    public ResponseEntity<List<ProductGamma>> findAll() {
        return ResponseEntity.ok(service.fetchProductGammasList());
    }
}