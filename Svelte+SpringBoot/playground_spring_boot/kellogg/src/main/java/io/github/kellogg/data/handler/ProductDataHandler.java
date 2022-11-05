package io.github.kellogg.data.handler;

import io.github.kellogg.data.entity.ProductEntity;

public interface ProductDataHandler {
    
    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

    ProductEntity getProductEntity(String productId);
}
