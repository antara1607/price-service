package com.example.price_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/v1/data")
public class PriceController {

    public static final Map<String, BigDecimal> priceMap = Map.of(
            "cheerios", BigDecimal.valueOf(5.25),
            "cornflakes",  BigDecimal.valueOf(2.52),
            "frosties",  BigDecimal.valueOf(10.00),
            "shreddies",  BigDecimal.valueOf(6.25),
            "weetabix",  BigDecimal.valueOf(9.98)
    );

    @GetMapping("/{item}/price")
    public BigDecimal getItemPrice(@PathVariable String item){
        return priceMap.getOrDefault(item, BigDecimal.ZERO);
    }
}
