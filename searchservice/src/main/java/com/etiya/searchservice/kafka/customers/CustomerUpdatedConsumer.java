package com.etiya.searchservice.kafka.customers;

import com.etiya.common.events.customers.CustomerUpdatedEvent;
import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.service.abstracts.FilterService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerUpdatedConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerUpdatedConsumer.class);
    private FilterService filterService;

    @KafkaListener(topics = "customer-updated", groupId = "update-customer")
    private void consume(CustomerUpdatedEvent customerUpdatedEvent){
        Customer customer = filterService.getById(customerUpdatedEvent.getId());
        customer.setNationalityIdentity(customerUpdatedEvent.getNationalityIdentity());
        customer.setId(customerUpdatedEvent.getId());
        customer.setFirstName(customerUpdatedEvent.getFirstName());
        customer.setMiddleName(customerUpdatedEvent.getMiddleName());
        customer.setLastName(customerUpdatedEvent.getLastName());

        LOGGER.info(String.format("Customer updated event consumer => %s", customerUpdatedEvent.toString()));
        this.filterService.updateCustomer(customer);
    }
}
