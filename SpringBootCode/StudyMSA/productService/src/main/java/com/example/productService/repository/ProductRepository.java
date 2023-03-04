package com.example.productService.repository;

import com.example.productService.dto.Product;
import com.example.productService.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository

@RequiredArgsConstructor
public class ProductRepository {
    private final ProductJpaRepository productJpaRepository;

    @Transactional
    public Product findByProductId(String productId){
        return Product.of(productJpaRepository.findByProductId(productId)
                .orElseThrow(IllegalArgumentException::new));
    }

    @Transactional
    public List<Product> findAll(){
        return productJpaRepository.findAll().stream()
                .map(Product::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public Product save(ProductEntity productEntity){
        return Product.of(productJpaRepository.save(productEntity));
    }


}
