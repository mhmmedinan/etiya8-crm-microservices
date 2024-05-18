package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.BillingAccount;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.CreateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.UpdateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.billingAccountResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillingAccountMapper {
    BillingAccountMapper INSTANCE = Mappers.getMapper(BillingAccountMapper.class);
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "address.id", target = "addressId")
    GetAllBillingAccountResponse getAllBillingAccountResponse(BillingAccount billingAccount);

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "addressId", target = "address.id")
    BillingAccount billingAccountFromCreateBillingAccountRequest(CreateBillingAccountRequest createBillingAccountRequest);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "address.id", target = "addressId")
    @Mapping(source = "accountNumber", target = "accountNumber")
    CreatedBillingAccountResponse createdBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);


    @Mapping(source = "addressId", target = "address.id")
    BillingAccount billingAccountFromUpdateBillingAccountRequest(UpdateBillingAccountRequest updateBillingAccountRequest);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "address.id", target = "addressId")
    UpdatedBillingAccountResponse updatedBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);

    DeletedBillingAccountResponse deletedBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "address.id", target = "addressId")
    GetBillingAccountResponse getBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);


}
