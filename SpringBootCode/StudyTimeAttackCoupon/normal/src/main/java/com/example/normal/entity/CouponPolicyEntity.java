package com.example.normal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Table(name="coupon_policies")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CouponPolicyEntity {
    @Column(name="coupon_policy_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponPolicyId;

    @Column
    private String title;

    @Column
    private Integer initQuantity;

    @Column
    private Integer issuedQuantity;

    @Column
    private Instant startDate;

    @Column
    private Instant endDate;


}
