package com.etiya.searchservice.kafka.contactMedium;

import com.etiya.common.events.contactMediums.ContactMediumUpdatedEvent;
import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.kafka.customers.CustomerCreatedConsumer;
import com.etiya.searchservice.service.abstracts.FilterService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactMediumUpdatedConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactMediumUpdatedConsumer.class);
    private FilterService filterService;

    @KafkaListener(topics = "contact-medium-updated", groupId = "update-contact-medium")
    private void consume(ContactMediumUpdatedEvent contactMediumUpdatedEvent){

        Customer customer = filterService.getById(contactMediumUpdatedEvent.getId());
        customer.setId(contactMediumUpdatedEvent.getId());
        customer.setMobilePhone(contactMediumUpdatedEvent.getMobilePhone());

        LOGGER.info(String.format("Contact Medium updated event consumer => %s", contactMediumUpdatedEvent.toString()));
        this.filterService.updateCustomer(customer);
    }
}
