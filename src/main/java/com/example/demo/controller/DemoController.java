package com.example.demo.controller;

import com.example.demo.entity.ExchangeRate;
import com.example.demo.service.ExchangeRateService;
import com.example.demo.service.ExchangeRateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {
    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping(value="/convert/{from}/{to}")//汇率转换方法
    public ExchangeRate ExchangeRateConversion(@PathVariable(name = "from") String from,
                                               @PathVariable(name = "to") String to,
                                               @RequestParam(name = "amount") int amount){
        ExchangeRate er= exchangeRateService.ExchangeRateConversion(from,to,amount);
        return er;
    }
}
