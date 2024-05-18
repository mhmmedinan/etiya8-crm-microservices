package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.business.abstracts.MessageService;
import com.etiyacrm.customerservice.core.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.repositories.AddressRepository;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressBusinessRules {
    private AddressRepository addressRepository;
    private MessageService messageService;
    public void checkIfAddressDeleted(LocalDateTime deletedDate){
        List<Address> addresses = addressRepository.findByDeletedDate(deletedDate);
        for (Address address : addresses){
            if (address.getDeletedDate()!= null){
                throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.AddressDeleted));
            }
        }
    }
}
