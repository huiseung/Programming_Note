package com.example.StudyConcurrency.service;


import com.example.StudyConcurrency.entity.Stock;
import com.example.StudyConcurrency.repository.StockRedisRepository;
import com.example.StudyConcurrency.repository.StockRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
public class StockServiceConcurrencyTest {
    @Autowired
    private StockService stockService;
    @Autowired
    private StockOptimisticLockFacade stockOptimisticLockFacade;

    @Autowired
    private StockLettuceLockFacade stockLettuceLockFacade;

    @Autowired
    private StockRepository stockRepository;
    private static Long stockId;
    private static Long productId = 1L;

    private ExecutorService executorService;
    private CountDownLatch countDownLatch;

    private final Long initQuantity = 300L;
    private final int threadCount = 100;
    private final Long orderQuantity = 1L;

    @BeforeEach
    public void beforeEach(){
        stockRepository.deleteAll();
        Stock stock = Stock.builder()
                .productId(productId)
                .quantity(initQuantity)
                .build();
        stockId = stockService.save(stock);
        executorService = Executors.newFixedThreadPool(threadCount);
        countDownLatch = new CountDownLatch(threadCount);
    }

    @Test
    @DisplayName("normal select : 1개씩 재고 감소 동시 100개 요청")
    public void testDecreaseV1() throws InterruptedException {
        int threadCount = 100;
        Long orderQuantity = 1L;
        // when
        for(int i = 0; i < threadCount; i++){
            executorService.submit(() -> {
                try{
                    stockService.decreaseV1(productId, orderQuantity);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        // then
        Stock stock = stockService.findByProductId(productId);
        Long afterQuantity = stock.getQuantity();
        System.out.println("stock: "+stock);
        assertEquals(initQuantity-threadCount*orderQuantity, afterQuantity);
    }

    @Test
    @DisplayName("synchronize select : 1개씩 재고 감소 동시 100개 요청")
    public void testDecreaseV2() throws InterruptedException {
        int threadCount = 100;
        Long orderQuantity = 1L;
        // when
        for(int i = 0; i < threadCount; i++){
            executorService.submit(() -> {
                try{
                    stockService.decreaseV2(productId, orderQuantity);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        // then
        Stock stock = stockService.findByProductId(productId);
        Long afterQuantity = stock.getQuantity();
        System.out.println("stock: "+stock);
        assertEquals(initQuantity-threadCount*orderQuantity, afterQuantity);
    }

    @Test
    @DisplayName("JPA pessimistic lock: 1개씩 재고 감소 동시 100개 요청")
    public void testDecreaseV3() throws InterruptedException {
        Long orderQuantity = 1L;
        // when
        for(int i = 0; i < threadCount; i++){
            executorService.submit(() -> {
                try{
                    stockService.decreaseV3(productId, orderQuantity);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        // then
        Stock stock = stockService.findByProductId(productId);
        Long afterQuantity = stock.getQuantity();
        System.out.println("stock: "+stock);
        assertEquals(initQuantity-threadCount*orderQuantity, afterQuantity);
    }

    @Test
    @DisplayName("JPA optimistic lock: 1개씩 재고 감소 동시 100개 요청")
    public void testDecreaseV4() throws InterruptedException {
        Long orderQuantity = 1L;
        // when
        for(int i = 0; i < threadCount; i++){
            executorService.submit(() -> {
                try{
                    stockOptimisticLockFacade.decreaseV4(productId, orderQuantity);
                } catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        // then
        Stock stock = stockService.findByProductId(productId);
        Long afterQuantity = stock.getQuantity();
        System.out.println("stock: "+stock);
        assertEquals(initQuantity-threadCount*orderQuantity, afterQuantity);
    }

    @Test
    @DisplayName("redis lock: 1개씩 재고 감소 동시 100개 요청")
    public void testDecreaseV5() throws InterruptedException {
        Long orderQuantity = 1L;
        // when
        for(int i = 0; i < threadCount; i++){
            executorService.submit(() -> {
                try{
                    stockLettuceLockFacade.decreaseV5(productId, orderQuantity);
                } catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        // then
        Stock stock = stockService.findByProductId(productId);
        Long afterQuantity = stock.getQuantity();
        System.out.println("stock: "+stock);
        assertEquals(initQuantity-threadCount*orderQuantity, afterQuantity);
    }
}
