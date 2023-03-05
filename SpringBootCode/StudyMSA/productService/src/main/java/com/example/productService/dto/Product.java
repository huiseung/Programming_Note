package com.example.productService.dto;

import com.example.productService.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Product {
    private Long id;
    private String productId;
    private String productName;
    private Integer stock;
    private Integer price;

    public static Product of(ProductEntity productEntity){
        return Product.builder()
                .id(productEntity.getId())
                .productId(productEntity.getProductId())
                .productName(productEntity.getProductName())
                .stock(productEntity.getStock())
                .price(productEntity.getPrice())
                .build();
    }

    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .id(id)
                .productId(productId)
                .productName(productName)
                .stock(stock)
                .price(price)
                .build();
    }

    public void minusStock(Integer stock){
        this.stock -= stock;
    }
}
