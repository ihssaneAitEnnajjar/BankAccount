package org.sid.bankaccounts.repositories;

import org.sid.bankaccounts.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {




}
