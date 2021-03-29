package com.springboot.onlinebanking.service.impl;

import com.springboot.onlinebanking.exception.DataProcessingException;
import com.springboot.onlinebanking.model.Currency;
import com.springboot.onlinebanking.repository.CurrencyRepository;
import com.springboot.onlinebanking.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Override
    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public Currency getByCurrencyName(String currencyName) {
        return currencyRepository.getCurrencyByCurrencyName(Currency.CurrencyName
                .valueOf(currencyName)).orElseThrow(() ->
                new DataProcessingException("Can't find currency by name" + currencyName));
    }
}
