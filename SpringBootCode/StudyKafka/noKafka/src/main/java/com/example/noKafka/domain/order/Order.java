package com.example.noKafka.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Order {
    private Long orderId;
    private Integer spendTotalMoney;
    private List<OrderProduct> orderProducts;
}
