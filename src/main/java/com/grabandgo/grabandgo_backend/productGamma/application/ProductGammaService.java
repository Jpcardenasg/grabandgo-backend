package com.grabandgo.grabandgo_backend.productGamma.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.productGamma.domain.ProductGamma;
import com.grabandgo.grabandgo_backend.productGamma.domain.DTO.ProductsGammaDTO;

public interface ProductGammaService {

    ProductGamma saveProductGamma(ProductGamma productGamma);

    ProductGamma updateProductGamma(Long id, ProductGamma productGamma);

    void deleteProductGamma(Long id);

    ProductsGammaDTO getProductGammaById(Long id);

    List<ProductsGammaDTO> fetchProductGammasList();

}