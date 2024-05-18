package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin()
@RequestMapping("customerservice/api/v1/addresses")
public class AddressesController {
    private AddressService addressService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedAddressResponse add(@Valid @RequestBody CreateAddressRequest createAddressRequest){
        return addressService.add(createAddressRequest);
    }

    @GetMapping("/paging")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public PageInfoResponse<GetAllAddressResponse> getAllPage(PageInfo pageInfo){
        return addressService.getAllPage(pageInfo);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetAllAddressResponse> getAll(){
        return addressService.getAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public List<GetAddressResponse> getById(@PathVariable String id){
        return addressService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedAddressResponse update(@Valid @RequestBody UpdateAddressRequest updateAddressRequest,
                                         @PathVariable String id){
        return addressService.update(updateAddressRequest, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedAddressResponse delete(@PathVariable String id){
        return addressService.delete(id);
    }

}
