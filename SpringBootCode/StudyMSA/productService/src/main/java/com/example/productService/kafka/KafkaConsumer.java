package com.example.productService.kafka;

import com.example.productService.dto.Product;
import com.example.productService.entity.ProductEntity;
import com.example.productService.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final ProductRepository productRepository;

    @KafkaListener(topics="example-order-topic")
    public void processMessage(String kafkaMessage){
        log.info("Kafka Message: "+kafkaMessage);
        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Product product = productRepository.findByProductId((String) map.get("productId"));
        product.minusStock((Integer) map.get("quantity"));
        productRepository.save(product.toEntity());
    }
}
