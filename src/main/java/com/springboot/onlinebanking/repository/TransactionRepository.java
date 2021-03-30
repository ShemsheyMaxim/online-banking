package com.springboot.onlinebanking.repository;

import com.springboot.onlinebanking.model.Account;
import com.springboot.onlinebanking.model.Transaction;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t WHERE t.fromAccount = :account OR t.toAccount = :account")
    List<Transaction> getAllByAccount(Account account, Pageable pageable);
}
