package io.github.kellogg.data.dao;

import io.github.kellogg.data.entity.ProductEntity;

public interface ProductDAO {
    
    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
