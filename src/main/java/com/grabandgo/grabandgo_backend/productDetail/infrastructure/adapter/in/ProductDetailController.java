package com.grabandgo.grabandgo_backend.productDetail.infrastructure.adapter.in;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

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

import com.grabandgo.grabandgo_backend.productDetail.application.ProductDetailService;
import com.grabandgo.grabandgo_backend.productDetail.domain.ProductDetail;


@Validated
@RestController
@RequestMapping("/api/productDetail")
public class ProductDetailController {

    @Autowired
    private ProductDetailService service;

    @PostMapping("/saveProductDetail")
    public ResponseEntity<ProductDetail> saveProductDetail(@Valid @RequestBody ProductDetail productDetail) {
        service.saveProductDetail(productDetail);
        return ResponseEntity.ok(productDetail);
    }

    @PutMapping("/updateProductDetail/{productDetailId}")
    public ResponseEntity<ProductDetail> updateProductDetail(@PathVariable Long productDetailId,
            @Valid @RequestBody ProductDetail productDetail) {
        service.updateProductDetail(productDetailId, productDetail);
        return ResponseEntity.ok(productDetail);
    }

    @DeleteMapping("/deleteProductDetail/{productDetailId}")
    public ResponseEntity<Long> deleteProductDetail(@PathVariable Long productDetailId) {
        service.deleteProductDetail(productDetailId);
        return ResponseEntity.ok(productDetailId);
    }

    @GetMapping("/allProductDetails")
    public ResponseEntity<List<ProductDetail>> findAll() {
        return ResponseEntity.ok(service.fetchProductDetailList());
    }

    @GetMapping("/getProductDetail/{id}")
    public ResponseEntity<Optional<ProductDetail>> getProductDetail(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProductDetailById(id));
    }
    
}