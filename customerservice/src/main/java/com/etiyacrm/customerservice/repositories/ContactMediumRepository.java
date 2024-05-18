package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.ContactMedium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactMediumRepository extends JpaRepository<ContactMedium, String> {
    Optional<ContactMedium> findByCustomerId(String customerId);

}
