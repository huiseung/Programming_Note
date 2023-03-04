package com.example.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ComponentScan({"com.example"})
@EnableJpaRepositories({"com.example.core.repository"})
@EntityScan({"com.example.core.entity"})
@SpringBootApplication
public class CouponBatchApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-core,application-batch");
        SpringApplication.run(CouponBatchApplication.class, args);
    }
}
