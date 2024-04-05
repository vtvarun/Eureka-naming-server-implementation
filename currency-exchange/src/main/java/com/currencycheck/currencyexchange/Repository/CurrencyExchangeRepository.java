package com.currencycheck.currencyexchange.Repository;

import com.currencycheck.currencyexchange.Model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {

    @Query(value = "SELECT * FROM currency_exchange WHERE country_from =:from AND country_to =:to",nativeQuery = true)
    CurrencyExchange getRates(@Param("from") String from,@Param("to") String to);
}
