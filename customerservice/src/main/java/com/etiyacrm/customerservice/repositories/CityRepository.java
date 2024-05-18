package com.etiyacrm.customerservice.repositories;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, String> {

    Optional<City> findByNameIgnoreCase(String name);

    List<City> findByDeletedDate(LocalDateTime deletedDate);

}
