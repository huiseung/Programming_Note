package com.example.core.dto.request;

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

    @Override
    public String toString() {
        return "CouponPolicyCreateRequestDto{" +
                "title='" + title + '\'' +
                ", initQuantity=" + initQuantity +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
