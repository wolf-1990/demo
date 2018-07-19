package com.example.demo.entity;

import java.util.Enumeration;

public enum ExchangeRateEnum{

    CNY("人民币"),USD("美元"),JPY("日元"),EUR("欧元"),GBP("英镑");
    ExchangeRateEnum(String name){

    }
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
