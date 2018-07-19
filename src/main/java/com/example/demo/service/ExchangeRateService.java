package com.example.demo.service;

import com.example.demo.entity.ExchangeRate;

public interface ExchangeRateService {
    public ExchangeRate ExchangeRateConversion(String from, String to, int amount);
}
