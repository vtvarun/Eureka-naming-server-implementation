package com.currencycheck.currencyexchange.Controller;

import com.currencycheck.currencyexchange.Model.CurrencyExchange;
import com.currencycheck.currencyexchange.Service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyExchangeController {

    @Autowired
    CurrencyExchangeService currencyExchangeService;
    @PostMapping("/add-currency-rates/from/{from}/to/{to}/rates/{rates}")
    public ResponseEntity<CurrencyExchange> addRates(@PathVariable String from, @PathVariable String to,
                                                     @PathVariable Double rates){
        return currencyExchangeService.addRates(from,to,rates);
    }

    @GetMapping("/get-exchange-rates/from/{from}/to/{to}")
    public CurrencyExchange getRates(@PathVariable String from, @PathVariable String to){
        return currencyExchangeService.getRates(from,to);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public String deleteById(@PathVariable Integer id){
        currencyExchangeService.deleteById(id);
        return "The entry has been deleted";
    }


}
