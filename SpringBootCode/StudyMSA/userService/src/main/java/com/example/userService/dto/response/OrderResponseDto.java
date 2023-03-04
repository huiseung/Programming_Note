package com.example.userService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderResponseDto {
    private String orderId;
    private String productId;
    private Integer quantity;
    private Integer unitPrice;


}
