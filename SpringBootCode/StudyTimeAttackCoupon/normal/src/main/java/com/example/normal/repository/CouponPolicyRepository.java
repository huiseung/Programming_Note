package com.example.normal.repository;

import com.example.normal.dto.CouponPolicy;
import com.example.normal.entity.CouponPolicyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class CouponPolicyRepository {
    private final CouponPolicyJpaRepository couponPolicyJpaRepository;

    @Transactional
    public CouponPolicy save(CouponPolicyEntity couponPolicyEntity) {
        return CouponPolicy.of(couponPolicyJpaRepository.save(couponPolicyEntity));
    }
    @Transactional(readOnly = true)
    public CouponPolicy findById(Long couponPolicyId){
        return CouponPolicy.of(couponPolicyJpaRepository.findById(couponPolicyId)
                .orElseThrow(IllegalArgumentException::new));
    }
    @Transactional(readOnly = true)
    public CouponPolicy findByTitle(String title){
        return CouponPolicy.of(couponPolicyJpaRepository.findByTitle(title)
                .orElseThrow(IllegalArgumentException::new));
    }
}
