package com.etiya.searchservice.kafka.customers;


import com.etiya.common.events.customers.CustomerCreatedEvent;
import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.service.abstracts.FilterService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CustomerCreatedConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCreatedConsumer.class);
    private FilterService filterService;

    @KafkaListener(topics = "customer-created", groupId = "create-customer")
    private void consume(CustomerCreatedEvent customerCreatedEvent){
        Customer customer = new Customer();
        customer.setNationalityIdentity(customerCreatedEvent.getNationalityIdentity());
        customer.setId(customerCreatedEvent.getId());
        customer.setMobilePhone(customerCreatedEvent.getMobilePhone());
        customer.setFirstName(customerCreatedEvent.getFirstName());
        customer.setMiddleName(customerCreatedEvent.getMiddleName());
        customer.setLastName(customerCreatedEvent.getLastName());

        LOGGER.info(String.format("Customer created event consumer => %s", customerCreatedEvent.toString()));
        this.filterService.addCustomer(customer);
    }
}
