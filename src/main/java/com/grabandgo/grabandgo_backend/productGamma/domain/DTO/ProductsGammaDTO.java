package com.grabandgo.grabandgo_backend.productGamma.domain.DTO;

import java.util.List;

import com.grabandgo.grabandgo_backend.product.domain.Product;
import com.grabandgo.grabandgo_backend.productGamma.domain.ProductGamma;

import lombok.Data;

/**
 * ProductsGammaDTO
 */
@Data
public class ProductsGammaDTO {

    private Long id;
    private String textDescription;
    private String htmlDescription;
    private String image;
    List<Product> products;

    public ProductsGammaDTO(ProductGamma pg) {
        id = pg.getId();
        textDescription = pg.getTextDescription();
        htmlDescription = pg.getHtmlDescription();
        image = pg.getImage();
        products = pg.getProducts();
    }

}