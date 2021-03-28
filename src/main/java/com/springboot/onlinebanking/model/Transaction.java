package com.springboot.onlinebanking.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "from_account")
    private Account fromAccount;
    @OneToOne
    @JoinColumn(name = "to_account")
    private Account toAccount;
    private LocalDateTime date;
    private BigDecimal amount;
    @ManyToOne
    private TypeOperation type;
}
