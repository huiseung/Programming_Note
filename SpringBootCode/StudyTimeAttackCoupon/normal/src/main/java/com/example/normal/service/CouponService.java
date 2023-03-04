package com.example.normal.service;

import com.example.normal.dto.Coupon;
import com.example.normal.dto.CouponPolicy;
import com.example.normal.dto.User;
import com.example.normal.entity.CouponEntity;
import com.example.normal.entity.CouponPolicyEntity;
import com.example.normal.entity.CouponStatus;
import com.example.normal.repository.CouponPolicyRepository;
import com.example.normal.repository.CouponRepository;
import com.example.normal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;
    private final UserRepository userRepository;
    private final CouponPolicyRepository couponPolicyRepository;

    @Transactional
    public Coupon issue(Long userId, Long couponPolicyId){
        User user = userRepository.findById(userId);
        CouponPolicy couponPolicy = couponPolicyRepository.findById(couponPolicyId);

        if(issuable(user, couponPolicy)){
            CouponEntity couponEntity = CouponEntity.builder()
                    .status(CouponStatus.AVAILABLE)
                    .user(user.toEntity())
                    .couponPolicy(couponPolicy.toEntity())
                    .build();
            couponPolicy.plusIssuedQuantity();
            CouponPolicyEntity couponPolicyEntity = couponPolicy.toEntity();
            couponPolicyRepository.save(couponPolicyEntity);
            return couponRepository.save(couponEntity);
        }
        return null;
    }

    @Transactional
    public Boolean issuable(User user, CouponPolicy couponPolicy){
        return !checkIssued(user) && !checkQuantity(couponPolicy);
    }

    private Boolean checkIssued(User user){
        Optional<Coupon> couponOptional = couponRepository.findByUser(user.toEntity());
        return couponOptional.isPresent();
    }

    private Boolean checkQuantity(CouponPolicy couponPolicy){
        return couponPolicy.getInitQuantity() <= couponPolicy.getIssuedQuantity();
    }


    @Transactional(readOnly = true)
    public Coupon findById(Long couponId){
        return couponRepository.findById(couponId);
    }
}
