package org.sid.bankaccounts.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccounts.dto.BankAccountRequestDTO;
import org.sid.bankaccounts.dto.BankAccountResponseDTO;
import org.sid.bankaccounts.entities.BankAccount;
import org.sid.bankaccounts.entities.Customer;
import org.sid.bankaccounts.repositories.BankAccountRepository;
import org.sid.bankaccounts.repositories.CustomerRepository;
import org.sid.bankaccounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired

    private BankAccountRepository bankAccountRepository;
    @Autowired

    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount>  accountsList(){

        return  bankAccountRepository.findAll();


    }

    @QueryMapping
    public BankAccount  bankAccountById( @Argument String id){

        return  bankAccountRepository.findById( id)
                .orElseThrow(()-> new RuntimeException(String.format("Account %s not found", id)));


    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){

         return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id , @Argument BankAccountRequestDTO bankAccount){

        return accountService.updateAccount(id, bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id ){

         bankAccountRepository.deleteById(id);
return  true;
    }
    @QueryMapping
    public  List<Customer> customers() {
        return  customerRepository.findAll();


    }



}
