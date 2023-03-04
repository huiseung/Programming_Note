package com.example.core.dto;



import com.example.core.entity.CouponEntity;
import com.example.core.entity.CouponPolicyEntity;
import com.example.core.entity.CouponStatus;
import com.example.core.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Coupon {
    private Long couponId;
    private CouponStatus status;
    private Instant startDate;
    private Instant endDate;

    public static Coupon of(CouponEntity couponEntity){
        CouponPolicyEntity couponPolicyEntity = couponEntity.getCouponPolicy();
        if(couponPolicyEntity != null){
            return Coupon.builder()
                    .couponId(couponEntity.getCouponId())
                    .status(couponEntity.getStatus())
                    .startDate(couponPolicyEntity.getStartDate())
                    .endDate(couponPolicyEntity.getEndDate())
                    .build();
        }
        return Coupon.builder()
                .couponId(couponEntity.getCouponId())
                .status(couponEntity.getStatus())
                .build();

    }

    public CouponEntity toEntity(UserEntity userEntity, CouponPolicyEntity couponPolicyEntity){
        return CouponEntity.builder()
                .couponId(couponId)
                .couponPolicy(couponPolicyEntity)
                .user(userEntity)
                .status(status)
                .build();
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponId=" + couponId +
                ", status=" + status +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
