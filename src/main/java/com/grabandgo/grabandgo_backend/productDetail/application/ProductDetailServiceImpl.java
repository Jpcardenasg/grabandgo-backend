package com.grabandgo.grabandgo_backend.productDetail.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.productDetail.domain.DTO.ProductDetailDTO;
import com.grabandgo.grabandgo_backend.productDetail.domain.ProductDetail;
import org.springframework.stereotype.Service;

import com.grabandgo.grabandgo_backend.productDetail.infrastructure.adapter.out.ProductDetailRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductDetailRepository productDetailRepository;

    public ProductDetailServiceImpl(ProductDetailRepository productDetailRepository) {
        this.productDetailRepository = productDetailRepository;
    }

    @Transactional
    @Override
    public void saveProductDetail(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Transactional
    @Override
    public void updateProductDetail(Long id, ProductDetail productDetail) {
        if (productDetailRepository.existsById(id)) {
            productDetail.setId(id);
            productDetailRepository.save(productDetail);
        } else {
            throw new RuntimeException("ProductDetail not found with id: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteProductDetail(Long id) {
        productDetailRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<ProductDetail> getProductDetailById(Long id) {
        return productDetailRepository.findById(id);
    }

    @Transactional
    @Override
    public List<ProductDetail> fetchProductDetailList() {
        return productDetailRepository.findAll();
    }

    @Override
    public ProductDetailDTO convertToDTO(ProductDetail productDetail) {

        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        return null;
    }

    @Override
    public ProductDetail convertToEntity(ProductDetailDTO productDetailDTO) {
        return null;
    }



}
