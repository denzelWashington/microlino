package net.wassim.accountservice.entities;


import jakarta.persistence.*;
import lombok.*;
import net.wassim.accountservice.enums.AccountType;
import net.wassim.accountservice.model.Customer;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}
