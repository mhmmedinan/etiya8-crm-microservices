package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, String> {
}
