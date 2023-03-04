package com.example.productService.service;

import com.example.productService.dto.Product;
import com.example.productService.entity.ProductEntity;
import com.example.productService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @Transactional
    public Product save(Product product){
        ProductEntity productEntity = ProductEntity.builder()
                .productId(UUID.randomUUID().toString())
                .productName(product.getProductName())
                .stock(product.getStock())
                .price(product.getPrice())
                .build();
        return productRepository.save(productEntity);
    }
}
