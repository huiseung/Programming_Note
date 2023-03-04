package com.example.normal.repository;

import com.example.normal.dto.Coupon;
import com.example.normal.entity.CouponEntity;
import com.example.normal.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CouponRepository {
    private final CouponJpaRepository couponJpaRepository;


    @Transactional
    public Coupon save(CouponEntity couponEntity){
        return Coupon.of(couponJpaRepository.save(couponEntity));
    }

    @Transactional(readOnly = true)
    public Coupon findById(Long couponId){
        return Coupon.of(couponJpaRepository.findById(couponId)
                .orElseThrow(IllegalArgumentException::new)
        );
    }

    @Transactional(readOnly = true)
    public Optional<Coupon> findByUser(UserEntity userEntity){
        Optional<CouponEntity> couponEntityOptional = couponJpaRepository.findByUserEntity(userEntity);
        if(couponEntityOptional.isPresent()){
            CouponEntity couponEntity = couponEntityOptional.get();
            return Optional.of(Coupon.of(couponEntity));
        }
        return Optional.empty();
    }
}
