package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.entities.Catalog;
import com.etiya.catalogservice.repositories.CatalogRepository;
import com.etiya.catalogservice.services.abstracts.CatalogService;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.CreateCatalogRequest;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.UpdateCatalogRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.CreatedCampaignResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.GetAllCampaignResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.UpdatedCapmaignResponse;
import com.etiya.catalogservice.services.dtos.responses.catalogResponses.*;
import com.etiya.catalogservice.services.mappers.CatalogMapper;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private CatalogRepository catalogRepository;

    @Override
    public CreatedCatalogResponse add(CreateCatalogRequest createCatalogRequest) {
        Catalog catalog =
                CatalogMapper.INSTANCE.catalogFromCreateCatalogRequest(createCatalogRequest);
        Catalog createdCatalog = catalogRepository.save(catalog);

        CreatedCatalogResponse createdCatalogResponse =
                CatalogMapper.INSTANCE.createdCatalogResponseFromCatalog(createdCatalog);

        return createdCatalogResponse;
    }

    @Override
    public UpdatedCatalogResponse update(UpdateCatalogRequest updateCatalogRequest, String id) {
        Catalog catalog =
                CatalogMapper.INSTANCE.catalogFromUpdateCatalogRequest(updateCatalogRequest);
        catalog.setId(id);
        catalog.setUpdatedDate(LocalDateTime.now());
        Catalog updatedCatalog = catalogRepository.save(catalog);

        UpdatedCatalogResponse updatedCatalogResponse =
                CatalogMapper.INSTANCE.updatedCatalogResponseFromCatalog(updatedCatalog);

        return updatedCatalogResponse;
    }

    @Override
    public List<GetAllCatalogResponse> getAll() {
        List<Catalog> catalogList = catalogRepository.findAll();
        List<GetAllCatalogResponse> getAllCatalogResponseList =
                catalogList.stream().map(CatalogMapper.INSTANCE::getAllCatalogResponseFromCatalog)
                        .collect(Collectors.toList());

        return getAllCatalogResponseList;
    }

    @Override
    public GetCatalogResponse getById(String id) {
        Catalog catalog = catalogRepository.findById(id).get();
        GetCatalogResponse getCatalogResponse =
                CatalogMapper.INSTANCE.getCatalogResponseFromCatalog(catalog);

        return getCatalogResponse;
    }

    @Override
    public DeletedCatalogResponse delete(String id) {
        Catalog catalog = catalogRepository.findById(id).get();
        catalog.setId(id);
        catalog.setDeletedDate(LocalDateTime.now());
        Catalog deletedCatalog = catalogRepository.save(catalog);

        DeletedCatalogResponse deletedCatalogResponse =
                CatalogMapper.INSTANCE.deletedCatalogResponseFromCatalog(deletedCatalog);

        return deletedCatalogResponse;
    }
}
