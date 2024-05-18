package com.etiyacrm.customerservice.services.abstracts;


import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.CreatedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.DeletedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.GetContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.UpdatedContactMediumResponse;

public interface ContactMediumService {
    CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest);
    UpdatedContactMediumResponse update(String id, UpdateContactMediumRequest updateContactMediumRequest);
    GetContactMediumResponse getById(String id);
    DeletedContactMediumResponse delete(String id);
}
