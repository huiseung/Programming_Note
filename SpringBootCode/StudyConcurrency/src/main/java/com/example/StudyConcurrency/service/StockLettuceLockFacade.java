package com.example.StudyConcurrency.service;

import com.example.StudyConcurrency.repository.StockRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class StockLettuceLockFacade {
    private final StockRedisRepository stockRedisRepository;
    private final StockService stockService;

    public void decreaseV5(final Long productId, final Long quantity) throws InterruptedException {
        while (!stockRedisRepository.lock(productId)) {
            Thread.sleep(100);
        }

        try {
            // 기본 재고 감소 로직 활용
            stockService.decreaseV1(productId, quantity);
        } finally {
            stockRedisRepository.unlock(productId);
        }
    }

}
