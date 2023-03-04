package com.example.api.controller;

import com.example.core.dto.CouponPolicy;
import com.example.core.dto.request.CouponPolicyCreateRequestDto;
import com.example.core.service.CouponPolicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/coupon-policies")
@Slf4j
@RestController
@RequiredArgsConstructor
public class CouponPolicyController {
    private final CouponPolicyService couponPolicyService;

    @PostMapping
    public CouponPolicy saveCouponPolicy(@RequestBody CouponPolicyCreateRequestDto requestDto){
        return couponPolicyService.save(requestDto);
    }
}