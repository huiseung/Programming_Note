package com.example.batch.job;

import com.example.core.service.CouponService;
import com.example.core.service.QueueService;
import com.example.core.service.SetService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponIssueJob {
    private final QueueService queueService;
    private final SetService setService;
    private final CouponService couponService;
    private String title;

    public void setTitle(String title){
        this.title = title;
    }

    @Scheduled(fixedDelay = 1000)
    public void issueStep(){
        if(title != null){
            // pop
            Long userId = (Long) queueService.pop(title);
            // event handle
            if (userId != null){
                couponService.issue(userId, title);
                setService.add(title, userId);
            }
        }
    }
}
