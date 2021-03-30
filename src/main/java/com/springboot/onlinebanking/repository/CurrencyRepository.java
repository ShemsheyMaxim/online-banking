package com.springboot.onlinebanking.repository;

import com.springboot.onlinebanking.model.Currency;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> getCurrencyByCurrencyName(Currency.CurrencyName currencyName);
}
