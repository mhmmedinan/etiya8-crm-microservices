package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.business.abstracts.MessageService;
import com.etiyacrm.customerservice.core.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.District;
import com.etiyacrm.customerservice.repositories.DistrictRepository;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DistrictBusinessRules {
    private DistrictRepository districtRepository;
    private MessageService messageService;

    public void checkIfDistrictDeleted(LocalDateTime deletedDate){
        List<District> districts = districtRepository.findByDeletedDate(deletedDate);
        for (District district : districts){
            if (district.getDeletedDate() != null){
                throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.IndividualCustomerDeleted));
            }
        }
    }
}
