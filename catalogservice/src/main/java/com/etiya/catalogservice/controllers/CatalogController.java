package com.etiya.catalogservice.controllers;


import com.etiya.catalogservice.services.abstracts.CatalogService;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.CreateCatalogRequest;
import com.etiya.catalogservice.services.dtos.requests.catalogRequests.UpdateCatalogRequest;
import com.etiya.catalogservice.services.dtos.responses.catalogResponses.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/catalogs")
public class CatalogController {
    private CatalogService catalogService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCatalogResponse add(@Valid @RequestBody CreateCatalogRequest createCatalogRequest){
        return catalogService.add(createCatalogRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetAllCatalogResponse> getAll(){
        return catalogService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public GetCatalogResponse getById(@PathVariable String id){
        return catalogService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedCatalogResponse update(@Valid @RequestBody UpdateCatalogRequest updateCatalogRequest,
                                         @PathVariable String id){
        return catalogService.update(updateCatalogRequest, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCatalogResponse delete(@PathVariable String id){
        return catalogService.delete(id);
    }
}
