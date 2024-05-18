package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,String> {
    List<Address> findByDeletedDate(LocalDateTime deletedDate);

    List<Address> findByCustomerId(String customerId);
}
