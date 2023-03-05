package com.example.orderService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateRequestDto {
    @NotNull
    private String productId;
    @NotNull
    private Integer quantity;
    @NotNull
    private Integer unitPrice;
}
