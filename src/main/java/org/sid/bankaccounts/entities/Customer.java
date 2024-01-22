package org.sid.bankaccounts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Customer {
    @Id @GeneratedValue
    private  Long id;
    private  String nom;
    @OneToMany(mappedBy = "customer")
    private List<BankAccount> bankAccounts;
}
