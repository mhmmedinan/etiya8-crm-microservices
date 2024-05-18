package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.CharacteristicValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicValueRepository extends JpaRepository<CharacteristicValue, String> {
}
