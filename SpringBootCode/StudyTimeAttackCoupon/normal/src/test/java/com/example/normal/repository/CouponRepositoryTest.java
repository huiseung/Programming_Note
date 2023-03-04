package com.example.normal.repository;

import com.example.normal.dto.Coupon;
import com.example.normal.dto.User;
import com.example.normal.entity.CouponEntity;
import com.example.normal.entity.CouponStatus;
import com.example.normal.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@SpringBootTest
public class CouponRepositoryTest {
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        // given
        UserEntity userEntity = UserEntity.builder()
                .name("testName")
                .build();
        User savedUser = userRepository.save(userEntity);
        // when
        Optional<Coupon> couponOptional = couponRepository.findByUser(savedUser.toEntity());
        // then
        System.out.println("couponOptional: "+couponOptional);
    }

    @Test
    public void testSavedCoupon(){
        // given
        UserEntity userEntity = UserEntity.builder()
                .name("testName")
                .build();
        User savedUser = userRepository.save(userEntity);

        CouponEntity couponEntity = CouponEntity.builder()
                .user(savedUser.toEntity())
                .status(CouponStatus.AVAILABLE)
                .build();
        couponRepository.save(couponEntity);
        // when
        Optional<Coupon> couponOptional = couponRepository.findByUser(savedUser.toEntity());
        // then
        System.out.println("couponOptional: "+couponOptional);
    }
}
