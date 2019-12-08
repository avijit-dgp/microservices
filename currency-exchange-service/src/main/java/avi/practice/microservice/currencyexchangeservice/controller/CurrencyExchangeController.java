package avi.practice.microservice.currencyexchangeservice.controller;

import avi.practice.microservice.currencyexchangeservice.beans.ExchangeValue;
import avi.practice.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository exchangeRepository;

    @GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public ExchangeValue getExchangeRate(@PathVariable("fromCurrency") String fromCurrency, @PathVariable String toCurrency) {
        //ExchangeValue exchangeValue = new ExchangeValue(fromCurrency, toCurrency, BigDecimal.valueOf(65));
        //exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
        ExchangeValue exchangeValue = exchangeRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
        if(null != exchangeValue) {
            exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
        }
        return exchangeValue;
    }
}
