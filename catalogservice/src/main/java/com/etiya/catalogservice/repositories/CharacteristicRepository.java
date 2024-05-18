package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CharacteristicRepository extends JpaRepository<Characteristic, String > {
}
