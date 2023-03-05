package com.example.orderService.kafka;

import com.example.orderService.dto.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Order send(String kafkaTopic, Order order){
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = objectMapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        kafkaTemplate.send(kafkaTopic, jsonInString);
        log.info("kafka producer send: "+order);
        return order;
    }
}
