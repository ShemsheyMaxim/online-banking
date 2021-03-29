package com.springboot.onlinebanking.repository;

import com.springboot.onlinebanking.model.Account;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByUserPhoneNumber(String userPhoneNumber);

    Optional<Account> findAccountByAccountNumber(String accountNumber);
}
