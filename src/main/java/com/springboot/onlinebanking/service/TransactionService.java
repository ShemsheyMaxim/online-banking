package com.springboot.onlinebanking.service;

import com.springboot.onlinebanking.model.Account;
import com.springboot.onlinebanking.model.Transaction;
import java.util.List;

public interface TransactionService {
    List<Transaction> getAllByAccount(int page, int size, Account account);
}
