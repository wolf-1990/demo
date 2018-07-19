package com.example.demo.entity;

import com.example.demo.utils.PropertiesUtils;

import java.math.BigDecimal;

public class ExchangeRate {
    public ExchangeRate() {
    }

    public ExchangeRate(BigDecimal amount, BigDecimal rate, String from, String to) {
        this.amount = amount;
        this.rate = rate;
        this.from = from;
        this.to = to;
    }

    private BigDecimal amount;//目标金额
    private BigDecimal rate;//汇率比例
    private String from;//目标币种
    private String to;//转换币种

    private String errorCode;//错误码
    private String errorMessage;//错误信息

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        String errorMessage = PropertiesUtils.getPropertyByName("errorcode.properties", this.getErrorCode());
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
