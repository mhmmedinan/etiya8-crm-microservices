package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.CreatedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.DeletedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.GetContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.UpdatedContactMediumResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMediumMapper {
    ContactMediumMapper INSTANCE = Mappers.getMapper(ContactMediumMapper.class);

    CreatedContactMediumResponse createdContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    UpdatedContactMediumResponse updatedContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    GetContactMediumResponse getContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    DeletedContactMediumResponse deletedContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    @Mapping(source = "customerId", target = "customer.id")
    ContactMedium contactMediumFromCreateContactMediumRequest(CreateContactMediumRequest createContactMediumRequest);
    ContactMedium contactMediumFromUpdateContactMediumRequest(UpdateContactMediumRequest updateContactMediumRequest);
}
