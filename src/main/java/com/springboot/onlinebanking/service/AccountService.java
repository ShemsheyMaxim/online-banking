package com.springboot.onlinebanking.service;

import com.springboot.onlinebanking.model.Account;
import java.util.List;

public interface AccountService {
    Account save(Account account);

    List<Account> findAllUserAccountsByUserPhone(String phoneNumber);

    Account findAccountByAccountNumber(String accountNumber);
}
