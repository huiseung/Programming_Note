package com.example.noKafka.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrderProduct {
    private Long orderRecordId;
    private Integer orderAmount;
    private Integer spendMoney;
}
