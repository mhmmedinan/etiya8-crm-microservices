package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.services.abstracts.CampaignProductOfferService;
import com.etiya.catalogservice.services.dtos.requests.campaignProductOfferRequests.CreateCampaignProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.campaignProductOfferRequests.UpdateCampaignProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/campaigns_product_offers")
public class CampaignProductOfferController {
    private CampaignProductOfferService campaignProductOfferService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCampaignProductOfferResponse add(@Valid @RequestBody CreateCampaignProductOfferRequest createCampaignProductOfferRequest){
        return campaignProductOfferService.add(createCampaignProductOfferRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedCampaignProductOfferResponse update(@Valid @RequestBody UpdateCampaignProductOfferRequest updateCampaignProductOfferRequest, @PathVariable String id) {
        return campaignProductOfferService.update(updateCampaignProductOfferRequest, id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetAllCampaignProductOfferResponse> getAll() {
        return campaignProductOfferService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public List<GetCampaignProductOfferResponse> getById(@PathVariable String id) {
        return campaignProductOfferService.findByProductOfferId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCampaignProductOfferResponse delete(@PathVariable String id) {
        return campaignProductOfferService.delete(id);
    }

}
