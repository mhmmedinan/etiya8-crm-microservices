package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.CreatedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.DeletedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.GetContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.UpdatedContactMediumResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin()
@RequestMapping("customerservice/api/v1/contact-mediums")
public class ContactMediumController {
    private ContactMediumService contactMediumService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedContactMediumResponse add(@Valid @RequestBody CreateContactMediumRequest createContactMediumRequest){
        return contactMediumService.add(createContactMediumRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public GetContactMediumResponse getById(@PathVariable String id){
        return contactMediumService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedContactMediumResponse update(@Valid @RequestBody UpdateContactMediumRequest updateContactMediumRequest,
                                               @PathVariable String id){
        return contactMediumService.update(id, updateContactMediumRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete")
    public DeletedContactMediumResponse delete(@PathVariable String id){
        return contactMediumService.delete(id);
    }
}
