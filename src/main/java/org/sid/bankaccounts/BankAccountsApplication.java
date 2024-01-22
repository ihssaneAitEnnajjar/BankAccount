package org.sid.bankaccounts;

import org.sid.bankaccounts.entities.BankAccount;
import org.sid.bankaccounts.entities.Customer;
import org.sid.bankaccounts.enums.AccountType;
import org.sid.bankaccounts.repositories.BankAccountRepository;
import org.sid.bankaccounts.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountsApplication.class, args);
    }
@Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){

        return  args -> {
            Stream.of("Mohamed","Yassine","Hanae","Imane").forEach(c->{
                Customer customer = Customer.builder()
                        .nom(c)

                        .build();
                customerRepository.save(customer);


            });
            customerRepository.findAll().forEach(customer -> {
                for (int i=0; i<10;i++){

                    BankAccount bankAccount =BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                            .balance(1000+Math.random()*9000)
                            .createdAt(new Date())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }


            });







        };



}

}
