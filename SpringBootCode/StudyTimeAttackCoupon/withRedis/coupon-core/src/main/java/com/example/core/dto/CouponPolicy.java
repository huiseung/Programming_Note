package com.example.core.dto;

import com.example.core.entity.CouponPolicyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CouponPolicy {
    private Long couponPolicyId;
    private String title;
    private Integer initQuantity;
    private Integer issuedQuantity;
    private Instant startDate;
    private Instant endDate;

    public static CouponPolicy of(CouponPolicyEntity couponPolicyEntity){
        return CouponPolicy.builder()
                .couponPolicyId(couponPolicyEntity.getCouponPolicyId())
                .title(couponPolicyEntity.getTitle())
                .initQuantity(couponPolicyEntity.getInitQuantity())
                .issuedQuantity(couponPolicyEntity.getIssuedQuantity())
                .startDate(couponPolicyEntity.getStartDate())
                .endDate(couponPolicyEntity.getEndDate())
                .build();
    }

    public CouponPolicyEntity toEntity(){
        return CouponPolicyEntity.builder()
                .couponPolicyId(couponPolicyId)
                .title(title)
                .initQuantity(initQuantity)
                .issuedQuantity(issuedQuantity)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

    public void plusIssuedQuantity(){
        this.issuedQuantity += 1;
    }

    @Override
    public String toString() {
        return "CouponPolicy{" +
                "couponPolicyId=" + couponPolicyId +
                ", title='" + title + '\'' +
                ", initQuantity=" + initQuantity +
                ", issuedQuantity=" + issuedQuantity +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
