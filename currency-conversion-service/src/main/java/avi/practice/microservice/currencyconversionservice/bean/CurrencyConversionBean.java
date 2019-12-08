package avi.practice.microservice.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionRate;
    private BigDecimal quantity;
    private BigDecimal totalAmount;
    private int port;

    public CurrencyConversionBean() {

    }

    public CurrencyConversionBean(Long id, String fromCurrency, String toCurrency, BigDecimal conversionRate, BigDecimal quantity, BigDecimal totalAmount, int port) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionRate = conversionRate;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
