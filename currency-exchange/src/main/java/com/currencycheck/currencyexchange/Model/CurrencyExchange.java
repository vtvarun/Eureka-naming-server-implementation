package com.currencycheck.currencyexchange.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String countryFrom;

    private String countryTo;

    private Double exchangeRate;

    private String portNumber;

    public CurrencyExchange() {
    }

    public CurrencyExchange(Integer id, String countryFrom, String countryTo, Double exchangeRate, String portNumber) {
        this.id = id;
        this.countryFrom = countryFrom;
        this.countryTo = countryTo;
        this.exchangeRate = exchangeRate;
        this.portNumber = portNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryFrom() {
        return countryFrom;
    }

    public void setCountryFrom(String countryFrom) {
        this.countryFrom = countryFrom;
    }

    public String getCountryTo() {
        return countryTo;
    }

    public void setCountryTo(String countryTo) {
        this.countryTo = countryTo;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }
}
