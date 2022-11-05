package io.github.kellogg.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.kellogg.data.entity.ProductEntity;

public interface ProductRepository  extends JpaRepository<ProductEntity,String>{
    
}
