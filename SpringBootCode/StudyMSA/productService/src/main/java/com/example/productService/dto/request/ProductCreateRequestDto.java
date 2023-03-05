package com.example.productService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductCreateRequestDto {
    @NotNull
    private String productName;
    @NotNull
    private Integer stock;
    @NotNull
    private Integer price;
}
