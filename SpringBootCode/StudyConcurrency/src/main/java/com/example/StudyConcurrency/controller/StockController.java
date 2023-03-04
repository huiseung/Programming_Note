package com.example.StudyConcurrency.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StockController {
    @GetMapping("/api/hello")
    public String hello(){
        return "hello";
    }
}
