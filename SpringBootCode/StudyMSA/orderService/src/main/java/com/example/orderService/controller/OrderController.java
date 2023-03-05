package com.example.orderService.controller;

import com.example.orderService.dto.Order;
import com.example.orderService.dto.request.OrderCreateRequestDto;
import com.example.orderService.dto.response.OrderResponseDto;
import com.example.orderService.kafka.KafkaProducer;
import com.example.orderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/order-service")
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final KafkaProducer kafkaProducer;

    @GetMapping("/health_check")
    public String healthCheck(){
        return "order-service It's working";
    }

    @PostMapping("/users/{userId}/orders")
    public OrderResponseDto createOrder(
            @PathVariable("userId") String userId,
            @RequestBody OrderCreateRequestDto requestDto){

        Order order = Order.builder()
                .userId(userId)
                .productId(requestDto.getProductId())
                .quantity(requestDto.getQuantity())
                .unitPrice(requestDto.getUnitPrice())
                .build();
        Order saveOrder = orderService.save(order);
        kafkaProducer.send("example-order-topic", order);
        return OrderResponseDto.of(saveOrder);
    }

    @GetMapping("/users/{userId}/orders")
    public List<OrderResponseDto> getOrdersByUsers(
            @PathVariable("userId") String userId
    ){
        return orderService.findAllByUserId(userId).stream()
                .map(OrderResponseDto::of)
                .collect(Collectors.toList());
    }
}
