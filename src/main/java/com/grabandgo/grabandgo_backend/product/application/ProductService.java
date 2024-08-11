package com.grabandgo.grabandgo_backend.product.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.product.domain.Product;

public interface ProductService {

    Product saveProduct(Product entity);

    Product updateProduct(Long id, Product entity);

    void deleteProduct(Long id);

    Optional<Product> getProductById(Long id);

    List<Product> fetchProductsList();

}