package com.grabandgo.grabandgo_backend.productDetail.application;

import java.util.List;
import java.util.Optional;

import com.grabandgo.grabandgo_backend.productDetail.domain.DTO.ProductDetailDTO;
import com.grabandgo.grabandgo_backend.productDetail.domain.ProductDetail;

public interface ProductDetailService {

    void saveProductDetail(ProductDetail productDetail);

    void updateProductDetail(Long id, ProductDetail productDetail);

    void deleteProductDetail(Long id);

    Optional<ProductDetail> getProductDetailById(Long id);

    List<ProductDetail> fetchProductDetailList();

    ProductDetailDTO convertToDTO(ProductDetail productDetail);

    ProductDetail convertToEntity(ProductDetailDTO productDetailDTO);


}