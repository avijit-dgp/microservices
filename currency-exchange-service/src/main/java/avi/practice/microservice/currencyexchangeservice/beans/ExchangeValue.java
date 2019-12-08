package avi.practice.microservice.currencyexchangeservice.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ExchangeValue {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionRate;
    private int port;

    public ExchangeValue() {

    }

    public ExchangeValue(String fromCurrency, String toCurrency, BigDecimal conversionRate) {
        super();
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionRate = conversionRate;
    }

    public long getId() {
        return id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
