package com.grabandgo.grabandgo_backend.productGamma.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.productGamma.domain.ProductGamma;

public interface ProductGammaService {

    ProductGamma saveProductGamma(ProductGamma productGamma);

    ProductGamma updateProductGamma(Long id, ProductGamma productGamma);

    void deleteProductGamma(Long id);

    ProductGamma getProductGammaById(Long id);

    List<ProductGamma> fetchProductGammasList();

}