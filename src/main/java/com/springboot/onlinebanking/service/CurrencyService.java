package com.springboot.onlinebanking.service;

import com.springboot.onlinebanking.model.Currency;

public interface CurrencyService {
    Currency save(Currency currency);

    Currency getByCurrencyName(String currencyName);
}
