package org.sid.bankaccounts.service;

import org.sid.bankaccounts.dto.BankAccountRequestDTO;
import org.sid.bankaccounts.dto.BankAccountResponseDTO;
import org.sid.bankaccounts.entities.BankAccount;
import org.sid.bankaccounts.enums.AccountType;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);


    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
