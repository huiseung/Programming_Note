package com.example.noKafka.application.order.port.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateOrderRequestDto {
    private Long productId;
    private Integer orderAmount;
}
