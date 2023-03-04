package com.example.orderService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateRequestDto {
    private String productId;
    private Integer quantity;
    private Integer unitPrice;
}
