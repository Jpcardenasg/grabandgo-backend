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

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    @Override
    public void updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            productRepository.save(product);
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
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public List<Product> fetchProductsList() {
        return productRepository.findAll();
    }

    @Override
    public Product convertToEntity(ProductDTO productDTO) {

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());

        return product;
    }

    @Override
    public ProductDTO convertToDTO(Product product) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());


        return productDTO;
    }

}
