package com.example.productService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductCreateRequestDto {
    private String productName;
    private Integer stock;
    private Integer price;
}
