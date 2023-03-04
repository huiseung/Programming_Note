package com.example.normal.controller;

import com.example.normal.dto.Coupon;
import com.example.normal.dto.request.CouponCreateRequestDto;
import com.example.normal.service.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/coupons")
@Slf4j
@RestController
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<?> createCoupon(@RequestBody CouponCreateRequestDto requestDto){
        Coupon coupon = couponService.issue(requestDto.getUserId(), requestDto.getCouponPolicyId());
        if(coupon != null){
            return new ResponseEntity<>(coupon, HttpStatus.OK);
        }
        return new ResponseEntity<>("발급 불가 입니다.", HttpStatus.OK);
    }
}
