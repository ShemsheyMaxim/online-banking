package com.springboot.onlinebanking.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "from_account", nullable = false)
    private Account fromAccount;
    @ManyToOne
    @JoinColumn(name = "to_account", nullable = false)
    private Account toAccount;
    @Column(nullable = false)
    private LocalDateTime date;
    @Column(nullable = false)
    private BigDecimal amount;
    @ManyToOne
    private TypeOperation type;
}
