package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.services.abstracts.DistrictService;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.CreateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.UpdateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.responses.districtResponses.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin()
@RequestMapping("customerservice/api/v1/districts")
public class DistrictController {

    private DistrictService districtService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedDistrictResponse add(@Valid @RequestBody CreateDistrictRequest createDistrictRequest){
        return districtService.add(createDistrictRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedDistrictResponse update(@Valid @RequestBody UpdateDistrictRequest updateDistrictRequest,
                                          @PathVariable String id){
        return districtService.update(updateDistrictRequest, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete")
    public DeletedDistrictResponse delete(@PathVariable String id){
        return districtService.delete(id);
    }

    @GetMapping("/paging")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetAll")
    public PageInfoResponse<GetAllDistrictResponse> getAllPage(PageInfo pageInfo) {
        return districtService.getAllPage(pageInfo);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetAll")
    public List<GetAllDistrictResponse> getAll() {
        return districtService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetById")
    public GetDistrictResponse getById(@PathVariable String id){
        return districtService.getById(id);
    }

}
