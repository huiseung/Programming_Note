package com.example.core.repository;

import com.example.core.entity.CouponPolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface CouponPolicyJpaRepository extends JpaRepository<CouponPolicyEntity, Long> {
    CouponPolicyEntity save(CouponPolicyEntity couponPolicyEntity);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<CouponPolicyEntity> findById(Long couponPolicyId);

    Optional<CouponPolicyEntity> findByTitle(String title);

}
