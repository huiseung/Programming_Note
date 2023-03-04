package com.example.normal.service;

import com.example.normal.dto.CouponPolicy;
import com.example.normal.dto.request.CouponPolicyCreateRequestDto;
import com.example.normal.entity.CouponPolicyEntity;
import com.example.normal.repository.CouponPolicyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponPolicyService {
    private final CouponPolicyRepository couponPolicyRepository;

    @Transactional
    public CouponPolicy save(CouponPolicyCreateRequestDto requestDto){
        CouponPolicyEntity couponPolicyEntity = CouponPolicyEntity.builder()
                .title(requestDto.getTitle())
                .initQuantity(requestDto.getInitQuantity())
                .issuedQuantity(0)
                .startDate(requestDto.getStartDate())
                .endDate(requestDto.getEndDate())
                .build();
        return couponPolicyRepository.save(couponPolicyEntity);
    }

    @Transactional(readOnly = true)
    public CouponPolicy findById(Long couponPolicyId){
        return couponPolicyRepository.findById(couponPolicyId);
    }

    @Transactional(readOnly = true)
    public CouponPolicy findByTitle(String title){
        return couponPolicyRepository.findByTitle(title);
    }
}
