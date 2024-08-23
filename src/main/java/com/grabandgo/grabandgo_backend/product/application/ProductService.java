package com.grabandgo.grabandgo_backend.product.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.product.domain.Product;
import com.grabandgo.grabandgo_backend.product.domain.DTO.ProductDTO;

public interface ProductService {

    void saveProduct(Product entity);

    void updateProduct(Long id, Product entity);

    void deleteProduct(Long id);

    Optional<Product> findProductById(Long id);

    List<Product> findAllProducts();

    Product toEntity(ProductDTO productDTO);

    ProductDTO toDTO(Product product);

}