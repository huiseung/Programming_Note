package com.example.orderService.service;

import com.example.orderService.dto.Order;
import com.example.orderService.entity.OrderEntity;
import com.example.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public Order save(Order order){
        OrderEntity orderEntity = OrderEntity.builder()
                .orderId(UUID.randomUUID().toString())
                .userId(order.getUserId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .unitPrice(order.getUnitPrice())
                .build();
        return orderRepository.save(orderEntity);
    }

    @Transactional
    public Order findByOrderId(String orderId){
        return orderRepository.findByOrderId(orderId);
    }

    @Transactional
    public List<Order> findAllByUserId(String userId){
        return orderRepository.findAllByUserId(userId);
    }
}
