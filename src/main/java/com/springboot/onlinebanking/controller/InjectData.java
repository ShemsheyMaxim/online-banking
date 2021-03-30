package com.springboot.onlinebanking.controller;

import com.springboot.onlinebanking.model.Account;
import com.springboot.onlinebanking.model.Currency;
import com.springboot.onlinebanking.model.Role;
import com.springboot.onlinebanking.model.TypeOperation;
import com.springboot.onlinebanking.model.User;
import com.springboot.onlinebanking.service.AccountService;
import com.springboot.onlinebanking.service.CurrencyService;
import com.springboot.onlinebanking.service.RoleService;
import com.springboot.onlinebanking.service.TransactionService;
import com.springboot.onlinebanking.service.TypeOperationService;
import com.springboot.onlinebanking.service.UserService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InjectData {
    private final UserService userService;
    private final RoleService roleService;
    private final CurrencyService currencyService;
    private final TypeOperationService typeOperationService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    @PostConstruct
    private void injectData() {
        Role roleUser = new Role();
        roleUser.setRoleName(Role.RoleName.USER);
        roleService.save(roleUser);
        Role roleAdmin = new Role();
        roleAdmin.setRoleName(Role.RoleName.ADMIN);
        roleService.save(roleAdmin);

        User max = new User();
        max.setName("Max");
        max.setPassword("max123");
        max.setDateOfBirth(LocalDate.of(1997, 4, 4));
        max.setPhoneNumber("+380956655267");
        max.setRoles(Set.of(roleAdmin));
        userService.save(max);
        System.out.println(max);

        Currency currencyUah = new Currency();
        currencyUah.setCurrencyName(Currency.CurrencyName.UAH);
        currencyService.save(currencyUah);
        Currency currencyUsd = new Currency();
        currencyUsd.setCurrencyName(Currency.CurrencyName.USD);
        currencyService.save(currencyUsd);
        Currency currencyEur = new Currency();
        currencyEur.setCurrencyName(Currency.CurrencyName.EUR);
        currencyService.save(currencyEur);

        TypeOperation typeOperationOut = new TypeOperation();
        typeOperationOut.setOperationName(TypeOperation.TypeOperationName.OUTCOMING);
        typeOperationService.save(typeOperationOut);
        TypeOperation typeOperationIn = new TypeOperation();
        typeOperationIn.setOperationName(TypeOperation.TypeOperationName.INCOMING);
        typeOperationService.save(typeOperationIn);

        Account maxFirstAccount = new Account();
        maxFirstAccount.setAccountNumber("123");
        maxFirstAccount.setCurrency(currencyUah);
        maxFirstAccount.setActive(true);
        maxFirstAccount.setUser(max);
        maxFirstAccount.setBalance(BigDecimal.valueOf(0));
        accountService.save(maxFirstAccount);

        Account maxSecondAccount = new Account();
        maxSecondAccount.setAccountNumber("456");
        maxSecondAccount.setCurrency(currencyUsd);
        maxSecondAccount.setActive(true);
        maxSecondAccount.setUser(max);
        maxSecondAccount.setBalance(BigDecimal.valueOf(1_000_000));
        accountService.save(maxSecondAccount);
    }
}
