package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.CatalogProductOffer;
import com.etiya.catalogservice.services.dtos.requests.catalogProductOfferRequests.CreateCatalogProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.catalogProductOfferRequests.UpdateCatalogProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatalogProductOfferMapper {
    CatalogProductOfferMapper INSTANCE = Mappers.getMapper(CatalogProductOfferMapper.class);
    @Mapping(source = "catalog.id", target = "catalogId")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    GetAllCatalogProductOfferResponse getAllCatalogProductOfferResponseFromCatalogProductOffer(CatalogProductOffer catalogProductOffer);
    @Mapping(source = "catalogId", target = "catalog.id")
    @Mapping(source = "productOfferId", target = "productOffer.id")
    CatalogProductOffer catalogProductOfferFromCreateCatalogProductOfferRequest(CreateCatalogProductOfferRequest createCatalogProductOfferRequest);
    @Mapping(source = "catalog.id", target = "catalogId")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    CreatedCatalogProductOfferResponse createdCatalogProductOfferResponseFromCatalogProductOffer(CatalogProductOffer catalogProductOffer);
    @Mapping(source = "catalogId", target = "catalog.id")
    @Mapping(source = "productOfferId", target = "productOffer.id")
    CatalogProductOffer catalogProductOfferFromUpdateCatalogProductOfferRequest(UpdateCatalogProductOfferRequest updateCatalogProductOfferRequest);
    @Mapping(source = "catalog.id", target = "catalogId")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    UpdatedCatalogProductOfferResponse updatedCatalogProductOfferResponseFromCatalogProductOffer(CatalogProductOffer catalogProductOffer);
    DeletedCatalogProductOfferResponse deletedCatalogProductOfferResponseFromCatalogProductOffer(CatalogProductOffer catalogProductOffer);
    @Mapping(source = "catalog.id", target = "catalogId")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    @Mapping(source = "catalog.name", target = "catalogName")
    @Mapping(source = "productOffer.name", target = "productOfferName")
    @Mapping(source = "productOffer.totalPrice", target = "productOfferTotalPrice")
    GetCatalogProductOfferResponse getCatalogProductOfferResponseFromCatalogProductOffer(CatalogProductOffer catalogProductOffer);
}
