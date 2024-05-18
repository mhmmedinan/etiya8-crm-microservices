package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BillingAccountRepository extends JpaRepository<BillingAccount, String> {
    List<BillingAccount> findByDeletedDate(LocalDateTime deletedDate);
    List<BillingAccount> findByCustomerId(String customerId);
}
