package com.example.productService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductRequestDto {
    private String productName;
    private Integer stock;
    private Integer price;
}
