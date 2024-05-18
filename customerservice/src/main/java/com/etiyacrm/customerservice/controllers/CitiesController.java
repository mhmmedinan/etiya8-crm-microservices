package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.dtos.requests.IndividualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.UpdatedIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.cityresponses.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin()
@RequestMapping("customerservice/api/v1/cities")
public class CitiesController {
    private CityService cityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCityResponse add(@Valid @RequestBody CreateCityRequest createCityRequest){
        return cityService.add(createCityRequest);
    }

    @GetMapping("/paging")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetAll")
    public PageInfoResponse<GetAllCityResponse> getAllPage(PageInfo pageInfo){
        return cityService.getAllPage(pageInfo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetAll")
    public List<GetAllCityResponse> getAll(){
        return cityService.getAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetById")
    public GetCityResponse getById(@PathVariable String id){
        return cityService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedCityResponse update(@Valid @RequestBody UpdateCityRequest updateCityRequest,
                                      @PathVariable String id){
        return cityService.update(updateCityRequest, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete")
    public DeletedCityResponse delete(@PathVariable String id){
        return cityService.delete(id);
    }

}
