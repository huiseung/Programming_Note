package com.example.core.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CouponCreateRequestDto {
    private Long userId;
    private Long couponPolicyId;
    private String couponTitle;

    @Override
    public String toString() {
        return "CouponCreateRequestDto{" +
                "userId=" + userId +
                ", couponPolicyId=" + couponPolicyId +
                ", couponTitle='" + couponTitle + '\'' +
                '}';
    }
}
