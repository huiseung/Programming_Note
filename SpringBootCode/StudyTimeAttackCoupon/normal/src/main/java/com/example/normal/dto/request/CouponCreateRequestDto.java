package com.example.normal.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CouponCreateRequestDto {
    private Long userId;
    private Long couponPolicyId;
    private String couponTitle;
}
