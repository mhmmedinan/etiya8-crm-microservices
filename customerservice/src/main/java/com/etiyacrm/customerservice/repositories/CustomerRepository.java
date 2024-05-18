package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}

