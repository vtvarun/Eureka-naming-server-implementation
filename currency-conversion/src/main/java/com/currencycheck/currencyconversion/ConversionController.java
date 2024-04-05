package com.currencycheck.currencyconversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {


    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/get-converted-amount/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversion getConversion(@PathVariable String from, @PathVariable String to,
                              @PathVariable Double amount){

        CurrencyConversion currencyConversion = currencyExchangeProxy.getRates(from,to);
        currencyConversion.setRequestedAmount(amount);
        currencyConversion.setConvertedAmount(amount * currencyConversion.getExchangeRate());

        return currencyConversion;
    }
}
