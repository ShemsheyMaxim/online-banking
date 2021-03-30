package com.springboot.onlinebanking.service.impl;

import com.springboot.onlinebanking.model.Account;
import com.springboot.onlinebanking.model.Transaction;
import com.springboot.onlinebanking.repository.TransactionRepository;
import com.springboot.onlinebanking.service.TransactionService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllByAccount(int page, int size, Account account) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return transactionRepository.getAllByAccount(account, pageable);
    }
}
