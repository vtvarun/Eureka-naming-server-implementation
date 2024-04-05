package com.currencycheck.currencyexchange.Service;

import com.currencycheck.currencyexchange.Model.CurrencyExchange;
import com.currencycheck.currencyexchange.Repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    Environment environment;

    public ResponseEntity<CurrencyExchange> addRates(String from, String to, Double rates) {

        CurrencyExchange currencyExchange = new CurrencyExchange();
        currencyExchange.setCountryFrom(from);
        currencyExchange.setCountryTo(to);
        currencyExchange.setExchangeRate(rates);
        //currencyExchange.setPortNumber(environment.getProperty("local.server.port"));

        currencyExchangeRepository.save(currencyExchange);

        return new ResponseEntity<>(currencyExchange, HttpStatus.CREATED);
    }

    public CurrencyExchange getRates(String from, String to) {
        CurrencyExchange exchange =  currencyExchangeRepository.getRates(from,to);
        exchange.setPortNumber(environment.getProperty("local.server.port"));
        return exchange;
    }

    public void deleteById(Integer id) {
        currencyExchangeRepository.deleteById(id);
    }
}
