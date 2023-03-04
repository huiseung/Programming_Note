package com.example.StudyConcurrency.repository;

import com.example.StudyConcurrency.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByProductId(Long productId);
//
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from Stock s where s.productId = :productId")
    Stock findByProductIdWithProductLock(@Param("productId") Long productId);

    @Lock(LockModeType.OPTIMISTIC)
    @Query("select s from Stock s where s.productId = :productId")
    Stock findByProductIdWitOptimisticLock(@Param("productId") Long productId);
}
