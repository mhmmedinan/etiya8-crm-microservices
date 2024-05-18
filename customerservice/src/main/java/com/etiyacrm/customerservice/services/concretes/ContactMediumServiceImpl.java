package com.etiyacrm.customerservice.services.concretes;

import com.etiya.common.events.contactMediums.ContactMediumUpdatedEvent;
import com.etiya.common.events.customers.CustomerCreatedEvent;
import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.kafka.producers.contactMediums.ContactMediumProducer;
import com.etiyacrm.customerservice.kafka.producers.customers.CustomerProducer;
import com.etiyacrm.customerservice.repositories.ContactMediumRepository;
import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses.GetIndividualCustomerResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.CreatedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.DeletedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.GetContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses.UpdatedContactMediumResponse;
import com.etiyacrm.customerservice.services.mappers.ContactMediumMapper;
import com.etiyacrm.customerservice.services.rules.ContactMediumBussinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {
    private ContactMediumRepository contactMediumRepository;
    private ContactMediumBussinessRules contactMediumBussinessRules;
    private IndividualCustomerService individualCustomerService;
    private CustomerProducer customerProducer;
    private ContactMediumProducer contactMediumProducer;

    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest) {
        //contactMediumBussinessRules.checkIfCustomerHasContactMedium(createContactMediumRequest.getCustomerId());

        ContactMedium contactMedium =
                ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);

        ContactMedium createdContactMedium = contactMediumRepository.save(contactMedium);

        CreatedContactMediumResponse createdContactMediumResponse =
                ContactMediumMapper.INSTANCE.createdContactMediumResponseFromContactMedium(createdContactMedium);
        createdContactMediumResponse.setId(createdContactMedium.getId());
        createdContactMediumResponse.setCustomerId(createdContactMedium.getCustomer().getId());

        GetIndividualCustomerResponse individualCustomer = individualCustomerService.getById(createdContactMedium.getCustomer().getId());
        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent();
        customerCreatedEvent.setNationalityIdentity(individualCustomer.getNationalityIdentity());
        customerCreatedEvent.setId(createdContactMedium.getCustomer().getId());
        customerCreatedEvent.setMobilePhone(createdContactMedium.getMobilePhone());
        customerCreatedEvent.setFirstName(individualCustomer.getFirstName());
        customerCreatedEvent.setMiddleName(individualCustomer.getMiddleName());
        customerCreatedEvent.setLastName(individualCustomer.getLastName());
        customerProducer.sendMessage(customerCreatedEvent);
        return createdContactMediumResponse;
    }

    @Override
    public UpdatedContactMediumResponse update(String id, UpdateContactMediumRequest updateContactMediumRequest) {

        ContactMedium savedContactMedium = contactMediumRepository.findById(id).get();
        ContactMedium contactMedium =
                ContactMediumMapper.INSTANCE.contactMediumFromUpdateContactMediumRequest(updateContactMediumRequest);
        contactMedium.setId(id);
        contactMedium.setCustomer(savedContactMedium.getCustomer());
        contactMedium.setUpdatedDate(LocalDateTime.now());

        ContactMedium updatedContactMedium = contactMediumRepository.save(contactMedium);

        UpdatedContactMediumResponse updatedContactMediumResponse =
                ContactMediumMapper.INSTANCE.updatedContactMediumResponseFromContactMedium(updatedContactMedium);
        updatedContactMediumResponse.setId(updatedContactMedium.getId());

        GetIndividualCustomerResponse individualCustomer = individualCustomerService.getById(updatedContactMedium.getCustomer().getId());

        ContactMediumUpdatedEvent contactMediumUpdatedEvent = new ContactMediumUpdatedEvent();
        contactMediumUpdatedEvent.setId(individualCustomer.getId());
        contactMediumUpdatedEvent.setMobilePhone(updatedContactMedium.getMobilePhone());
        contactMediumProducer.sendMessage(contactMediumUpdatedEvent);

        return updatedContactMediumResponse;
    }

    @Override
    public GetContactMediumResponse getById(String id) {
        contactMediumBussinessRules.checkIfContactMedium(id);

        ContactMedium contactMedium = contactMediumRepository.findByCustomerId(id).get();
        GetContactMediumResponse contactMediumResponse =
                ContactMediumMapper.INSTANCE.getContactMediumResponseFromContactMedium(contactMedium);
        contactMediumResponse.setCustomerId(contactMedium.getCustomer().getId());
        contactMediumResponse.setId(contactMedium.getId());
        return contactMediumResponse;
    }

    @Override
    public DeletedContactMediumResponse delete(String id) {

        ContactMedium contactMedium = contactMediumRepository.findById(id).get();
        contactMedium.setId(id);
        contactMedium.setDeletedDate(LocalDateTime.now());
        ContactMedium deletedContactMedium = contactMediumRepository.save(contactMedium);

        DeletedContactMediumResponse deletedContactMediumResponse = ContactMediumMapper.INSTANCE.deletedContactMediumResponseFromContactMedium(deletedContactMedium);
        deletedContactMediumResponse.setDeletedDate(deletedContactMedium.getDeletedDate());

        return deletedContactMediumResponse;
    }
}
