package com.example.orderService.dto.response;

import com.example.orderService.dto.Order;
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

    public static OrderResponseDto of(Order order){
        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .unitPrice(order.getUnitPrice())
                .build();
    }
}
