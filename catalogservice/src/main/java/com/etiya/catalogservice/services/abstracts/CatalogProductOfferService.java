package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.services.dtos.requests.catalogProductOfferRequests.CreateCatalogProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.catalogProductOfferRequests.UpdateCatalogProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses.*;

import java.util.List;

public interface CatalogProductOfferService {
    CreatedCatalogProductOfferResponse add(CreateCatalogProductOfferRequest createCatalogProductOfferRequest);
    UpdatedCatalogProductOfferResponse update(UpdateCatalogProductOfferRequest updateCatalogProductOfferRequest, String id);
    List<GetAllCatalogProductOfferResponse> getAll();
    GetCatalogProductOfferResponse finByProductOfferId(String id);
    DeletedCatalogProductOfferResponse delete(String id);
}
