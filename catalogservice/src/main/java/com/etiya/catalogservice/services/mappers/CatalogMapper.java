package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.Catalog;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.CreateCatalogRequest;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.UpdateCatalogRequest;
import com.etiya.catalogservice.services.dtos.responses.catalogResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);
    GetAllCatalogResponse getAllCatalogResponseFromCatalog(Catalog catalog);
    Catalog catalogFromCreateCatalogRequest(CreateCatalogRequest createCatalogRequest);
    CreatedCatalogResponse createdCatalogResponseFromCatalog(Catalog catalog);
    Catalog catalogFromUpdateCatalogRequest(UpdateCatalogRequest updateCatalogRequest);
    UpdatedCatalogResponse updatedCatalogResponseFromCatalog(Catalog catalog);
    DeletedCatalogResponse deletedCatalogResponseFromCatalog(Catalog catalog);
    GetCatalogResponse getCatalogResponseFromCatalog(Catalog catalog);

}