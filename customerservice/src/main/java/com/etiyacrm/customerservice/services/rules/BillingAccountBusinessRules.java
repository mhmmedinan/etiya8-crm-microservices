package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.business.abstracts.MessageService;
import com.etiyacrm.customerservice.core.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.BillingAccount;
import com.etiyacrm.customerservice.repositories.BillingAccountRepository;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.CreateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.GetAddressResponse;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillingAccountBusinessRules {
    private BillingAccountRepository billingAccountRepository;
    private AddressService addressService;
    private MessageService messageService;

    public void checkIfCustomerAddressExists(CreateBillingAccountRequest createBillingAccountRequest){
        List<GetAddressResponse> addressList = addressService.getById(createBillingAccountRequest.getCustomerId());
        for (GetAddressResponse address : addressList){
            if (!createBillingAccountRequest.getAddressId().equals(address.getId())){
                throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.AddressNotExistsOnCustomer));
            }
        }
    }
}
