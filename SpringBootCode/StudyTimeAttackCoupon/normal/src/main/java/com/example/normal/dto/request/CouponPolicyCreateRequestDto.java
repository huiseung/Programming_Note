package com.example.normal.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
public class CouponPolicyCreateRequestDto {
    private String title;
    private Integer initQuantity;
    private Instant startDate;
    private Instant endDate;
}
