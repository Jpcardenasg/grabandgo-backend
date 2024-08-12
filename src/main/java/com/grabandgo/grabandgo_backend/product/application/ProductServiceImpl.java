package com.grabandgo.grabandgo_backend.product.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.product.domain.Product;
import com.grabandgo.grabandgo_backend.product.domain.DTO.ProductDTO;
import com.grabandgo.grabandgo_backend.product.infrastructure.adapter.out.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id).map(this::toDto);
    }

    @Transactional
    @Override
    public List<ProductDTO> fetchProductsList() {
        return productRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private ProductDTO toDto(Product pd){
        return new ProductDTO(pd);
    }
}
