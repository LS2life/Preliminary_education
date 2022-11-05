package io.github.kellogg.data.handler;

public interface ProductDataHandler {
    
    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

    ProductEntity getProductEntity(String productId);
}
