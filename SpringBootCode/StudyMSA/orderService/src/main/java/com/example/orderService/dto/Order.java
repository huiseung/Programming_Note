package com.example.orderService.dto;

import com.example.orderService.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Order {
    private Long pk;
    private String orderId;

    private String productId;
    private String userId;

    private Integer quantity;
    private Integer unitPrice;

    public static Order of(OrderEntity orderEntity){
        return Order.builder()
                .pk(orderEntity.getPk())
                .orderId(orderEntity.getOrderId())
                .productId(orderEntity.getProductId())
                .userId(orderEntity.getUserId())
                .quantity(orderEntity.getQuantity())
                .unitPrice(orderEntity.getUnitPrice())
                .build();
    }

}
