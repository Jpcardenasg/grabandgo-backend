package com.grabandgo.grabandgo_backend.productGamma.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.productGamma.domain.ProductGamma;
import com.grabandgo.grabandgo_backend.productGamma.infrastructure.adapter.out.ProductGammaRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductGammaServiceImpl implements ProductGammaService {

    @Autowired
    private ProductGammaRepository productGammaRepository;

    @Transactional
    @Override
    public ProductGamma saveProductGamma(ProductGamma productGamma) {
        return productGammaRepository.save(productGamma);
    }

    @Transactional
    @Override
    public ProductGamma updateProductGamma(Long id, ProductGamma productGamma) {
        if (productGammaRepository.existsById(id)) {
            productGamma.setId(id);
            return productGammaRepository.save(productGamma);
        } else {
            throw new RuntimeException("ProductGamma not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteProductGamma(Long id) {
        productGammaRepository.deleteById(id);
    }

    @Transactional
    @Override
    public ProductGamma getProductGammaById(Long id) {
        return productGammaRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<ProductGamma> fetchProductGammasList() {
        return productGammaRepository.findAll();
    }

}
