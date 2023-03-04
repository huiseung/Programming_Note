package com.example.userService.client;

import com.example.userService.dto.response.OrderResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="order-service")
public interface OrderServiceClient {
    @GetMapping("/order-service/{userId}/orders")
   public List<OrderResponseDto> findAll(@PathVariable("userId") String userId);
}
