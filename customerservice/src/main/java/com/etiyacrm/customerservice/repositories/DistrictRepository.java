package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.District;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, String> {
    List<District> findByDeletedDate(LocalDateTime deletedDate);
}
