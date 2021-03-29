package com.springboot.onlinebanking.service.impl;

import com.springboot.onlinebanking.exception.DataProcessingException;
import com.springboot.onlinebanking.model.Account;
import com.springboot.onlinebanking.repository.AccountRepository;
import com.springboot.onlinebanking.service.AccountService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAllUserAccountsByUserPhone(String phoneNumber) {
        return accountRepository.findAllByUserPhoneNumber(phoneNumber);
    }

    @Override
    public Account findAccountByAccountNumber(String accountNumber) {
        return accountRepository.findAccountByAccountNumber(accountNumber).orElseThrow(() ->
                new DataProcessingException("Can't find account by account number = "
                        + accountNumber));
    }
}
