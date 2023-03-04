package com.example.orderService.repository;

import com.example.orderService.dto.Order;
import com.example.orderService.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final OrderJpaRepository orderJpaRepository;

    @Transactional
    public Order findByOrderId(String orderId){
        return Order.of(orderJpaRepository.findByOrderId(orderId)
                .orElseThrow(IllegalArgumentException::new));
    }

    @Transactional
    public List<Order> findAllByUserId(String userId){
        return orderJpaRepository.findAllByUserId(userId).stream()
                .map(Order::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public Order save(OrderEntity orderEntity){
        return Order.of(orderJpaRepository.save(orderEntity));
    }
}
