package com.example.productService.controller;

import com.example.productService.dto.Product;
import com.example.productService.dto.request.ProductCreateRequestDto;
import com.example.productService.dto.response.ProductResponseDto;
import com.example.productService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestMapping("/product-service")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/health_check")
    public String healthCheck(){
        return "product-service It's working";
    }

    @PostMapping
    public ProductResponseDto save(@RequestBody ProductCreateRequestDto requestDto){
        Product product = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName(requestDto.getProductName())
                .stock(requestDto.getStock())
                .price(requestDto.getPrice())
                .build();
        return ProductResponseDto.of(productService.save(product));
    }



    @GetMapping("/products")
    public List<ProductResponseDto> findAll(){
       return productService.findAll().stream()
               .map(ProductResponseDto::of)
               .collect(Collectors.toList());
    }
}
