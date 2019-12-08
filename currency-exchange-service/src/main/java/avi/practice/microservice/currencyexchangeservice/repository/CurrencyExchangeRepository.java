package avi.practice.microservice.currencyexchangeservice.repository;

import avi.practice.microservice.currencyexchangeservice.beans.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);

}
