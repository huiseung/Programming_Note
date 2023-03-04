package com.example.StudyConcurrency.service;

import com.example.StudyConcurrency.entity.Stock;
import com.example.StudyConcurrency.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    @Transactional
    public void decreaseV1(Long productId, Long quantity){
        Stock stock = findByProductId(productId);
        stock.decrease(quantity);
        stockRepository.saveAndFlush(stock);
    }

    @Transactional
    public synchronized void decreaseV2(Long productId, Long quantity){
        Stock stock = findByProductId(productId);
        stock.decrease(quantity);
        stockRepository.saveAndFlush(stock);
    }

    @Transactional
    public void decreaseV3(Long productId, Long quantity){
        Stock stock = findByProductIdWithPessimisticLock(productId);
        stock.decrease(quantity);
    }

    @Transactional
    public void decreaseV4(Long productId, Long quantity){
        Stock stock = findByProductIdWithOptimisticLock(productId);
        stock.decrease(quantity);
    }



    @Transactional
    public Long save(Stock stock){
        return stockRepository.save(stock).getId();
    }

    @Transactional
    public Stock findByProductId(Long productId){
        return stockRepository.findByProductId(productId)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Stock findByProductIdWithPessimisticLock(Long productId){
        return stockRepository.findByProductIdWithProductLock(productId);
    }

    @Transactional
    public Stock findByProductIdWithOptimisticLock(Long productId){
        return stockRepository.findByProductIdWitOptimisticLock(productId);
    }
}
