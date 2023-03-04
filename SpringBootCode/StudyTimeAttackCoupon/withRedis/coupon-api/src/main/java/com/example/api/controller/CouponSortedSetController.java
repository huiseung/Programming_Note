package com.example.api.controller;

import com.example.core.dto.request.CouponCreateRequestDto;
import com.example.core.service.QueueService;
import com.example.core.service.SetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/coupons")
@RestController
@RequiredArgsConstructor
public class CouponSortedSetController {
    private final QueueService queueService;
    private final SetService setService;

    @PostMapping
    public String zAdd(@RequestBody CouponCreateRequestDto requestDto){
        Boolean isIssued = setService.isExist(requestDto.getCouponTitle(), requestDto.getUserId());
        if(isIssued){
            return "이미 쿠폰 발급이 완료 된 계정입니다";
        }
        Boolean isPushed = queueService.push(requestDto.getCouponTitle(), requestDto.getUserId(), (double) System.currentTimeMillis());
        Long rank = queueService.rank(requestDto.getCouponTitle(), requestDto.getUserId());
        if(rank != null){
            return rank + "번째 대기자 입니다";
        }
        return "작업에 들어 갔습니다";
    }

    @GetMapping("/{couponTitle}/{userId}")
    public String rank(
            @PathVariable("couponTitle") String couponTitle,
            @PathVariable("userId") Long userId){
        Long rank = queueService.rank(couponTitle, userId);
        if(rank != null){
            return rank + "번째 대기자 입니다";
        }
        return "대기자가 아닙니다";
    }

    @GetMapping("/queue/{couponTitle}")
    public Boolean existQueue(@PathVariable("couponTitle") String couponTitle){
        return queueService.exist(couponTitle);
    }

    @GetMapping("/set/{couponTitle}")
    public Boolean existSet(@PathVariable("couponTitle") String couponTitle){
        return setService.exist(couponTitle);
    }

}
