package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.services.abstracts.BillingAccountService;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.CreateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.UpdateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.billingAccountResponses.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin()
@RequestMapping("customerservice/api/v1/billing-accounts")
public class BillingAccountController {
    private BillingAccountService billingAccountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedBillingAccountResponse add(@Valid @RequestBody CreateBillingAccountRequest createBillingAccountRequest) {
        return billingAccountService.add(createBillingAccountRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedBillingAccountResponse update(@Valid @RequestBody UpdateBillingAccountRequest updateBillingAccountRequest, @PathVariable String id){
        return billingAccountService.update(updateBillingAccountRequest, id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetAll")
    public List<GetAllBillingAccountResponse> getAll(){
        return billingAccountService.getAll();
    }

    @GetMapping("/paging")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetAll")
    public PageInfoResponse<GetAllBillingAccountResponse> getAllPage(PageInfo pageInfo) {
        return billingAccountService.getAllPage(pageInfo);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "GetById")
    public List<GetBillingAccountResponse> getById(@PathVariable String id){
        return billingAccountService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete")
    public DeletedBillingAccountResponse delete(@PathVariable String id) {
        return billingAccountService.delete(id);
    }
}
