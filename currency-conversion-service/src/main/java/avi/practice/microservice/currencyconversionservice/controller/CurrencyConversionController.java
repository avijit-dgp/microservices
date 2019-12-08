package avi.practice.microservice.currencyconversionservice.controller;

import avi.practice.microservice.currencyconversionservice.bean.CurrencyConversionBean;
import avi.practice.microservice.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convert(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        /*CurrencyConversionBean responseBody = new RestTemplate().
                getForObject("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);*/

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
        CurrencyConversionBean responseBody = responseEntity.getBody();

        return new CurrencyConversionBean(responseBody.getId(), from, to, responseBody.getConversionRate(), quantity, responseBody.getConversionRate().multiply(quantity), responseBody.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertUsingFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyConversionBean exchangeRate = currencyExchangeServiceProxy.getExchangeRate(from, to);
        return new CurrencyConversionBean(exchangeRate.getId(), from, to, exchangeRate.getConversionRate(), quantity, exchangeRate.getConversionRate().multiply(quantity), exchangeRate.getPort());
    }
}
