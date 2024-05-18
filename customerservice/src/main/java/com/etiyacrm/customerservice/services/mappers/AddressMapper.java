package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "customer.id", target = "customerId")
    GetAllAddressResponse getAllAddressResponse(Address address);

    @Mapping(source = "customer.id", target = "customerId")
    GetAllAddressResponse getAllListAddressResponse(Address address);

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "districtId", target = "district.id")
    Address addressFromCreateAddressRequest(CreateAddressRequest createAddressRequest);
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "district.id", target = "districtId")
    CreatedAddressResponse createdAddressResponseFromAddress(Address address);
    Address addressFromUpdateAddressRequest(UpdateAddressRequest updateAddressRequest);
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "district.id", target = "districtId")
    UpdatedAddressResponse updatedAddressResponseFromAddress(Address address);
    DeletedAddressResponse deletedAddressResponseFromAddress(Address address);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "district.id", target = "districtId")
    GetAddressResponse getAddressResponseFromAddress(Address address);

}
