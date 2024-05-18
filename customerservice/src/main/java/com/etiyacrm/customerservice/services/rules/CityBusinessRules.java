package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.business.abstracts.MessageService;
import com.etiyacrm.customerservice.core.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.repositories.CityRepository;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityBusinessRules {
    private CityRepository cityRepository;
    private MessageService messageService;

    public void  cityNameCanNotBeDuplicatedWhenInserted(String name){
        Optional<City> city = cityRepository.findByNameIgnoreCase(name);

        if(city.isPresent()){
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CityNameExists));
        }
    }

    public void checkIfCityDeleted(LocalDateTime deletedDate){
        List<City> cities = cityRepository.findByDeletedDate(deletedDate);
        for (City city : cities){
            if (city.getDeletedDate()!= null){
                throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CityDeleted));
            }
        }
    }
}