package com.etiyacrm.customerservice.kafka.producers.contactMediums;

import com.etiya.common.events.contactMediums.ContactMediumUpdatedEvent;
import com.etiyacrm.customerservice.kafka.producers.customers.CustomerProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ContactMediumProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerProducer.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ContactMediumProducer(KafkaTemplate<String, Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ContactMediumUpdatedEvent contactMediumUpdatedEvent){
        LOGGER.info(String.format("Contact Medium updated => %s", contactMediumUpdatedEvent.toString()));

        Message<ContactMediumUpdatedEvent> message = MessageBuilder.withPayload(contactMediumUpdatedEvent)
                .setHeader(KafkaHeaders.TOPIC, "contact-medium-updated")
                .build();

        kafkaTemplate.send(message);
    }
}
