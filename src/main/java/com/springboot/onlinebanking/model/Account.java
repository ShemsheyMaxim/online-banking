package com.springboot.onlinebanking.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@Data
@Entity
@Table(name = "accounts")
@Validated
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Currency currency;
    @DecimalMin(value = "0", message = "balance should be greater then equal to 0")
    private BigDecimal balance;
    @Column(name = "is_active")
    private boolean isActive;
    @ManyToOne
    @ToString.Exclude
    private User user;
}
