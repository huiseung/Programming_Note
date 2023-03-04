package com.example.batch.conotroller;

import com.example.batch.job.CouponIssueJob;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/batch/coupons")
@RestController
@RequiredArgsConstructor
public class CouponIssueJobController {
    private final CouponIssueJob couponIssueJob;

    @GetMapping("/{title}")
    public void run(@PathVariable("title")String title){
        couponIssueJob.setTitle(title);
    }
}
