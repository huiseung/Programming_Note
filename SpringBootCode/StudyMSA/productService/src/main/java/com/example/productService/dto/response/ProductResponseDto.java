package com.example.productService.dto.response;

import com.example.productService.dto.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductResponseDto {
    private String productId;
    private String productName;
    private Integer stock;
    private Integer price;

    public static ProductResponseDto of(Product product){
        return ProductResponseDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .stock(product.getStock())
                .price(product.getPrice())
                .build();
    }
}
