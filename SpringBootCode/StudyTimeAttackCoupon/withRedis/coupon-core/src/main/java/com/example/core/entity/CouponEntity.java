package com.example.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Table(name="coupons")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CouponEntity {
    @Column(name="coupon_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    @JoinColumn(name="user_id")
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @JoinColumn(name="coupon_policy_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CouponPolicyEntity couponPolicy;

    @Column
    @Enumerated(EnumType.STRING)
    private CouponStatus status;
}
