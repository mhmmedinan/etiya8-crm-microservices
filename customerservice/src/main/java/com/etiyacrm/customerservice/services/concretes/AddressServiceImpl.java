package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.District;
import com.etiyacrm.customerservice.repositories.AddressRepository;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.*;
import com.etiyacrm.customerservice.services.dtos.responses.cityresponses.GetAllCityResponse;
import com.etiyacrm.customerservice.services.mappers.AddressMapper;
import com.etiyacrm.customerservice.services.mappers.CityMapper;
import com.etiyacrm.customerservice.services.rules.AddressBusinessRules;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private AddressBusinessRules addressBusinessRules;


    @Override
    public PageInfoResponse<GetAllAddressResponse> getAllPage(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<Address> response =  addressRepository.findAll(pageable);
        Page<GetAllAddressResponse> responsePage = response
                .map(address -> AddressMapper.INSTANCE.getAllAddressResponse(address));
        return new PageInfoResponse<>(responsePage);
    }

    @Override
    public List<GetAllAddressResponse> getAll() {

        List<Address> response =  addressRepository.findAll();
        List<GetAllAddressResponse> responsePage = response.stream()
                .map(address -> AddressMapper.INSTANCE.getAllListAddressResponse(address))
                .collect(Collectors.toList());
        return responsePage;
    }

    @Override
    public List<GetAddressResponse> getById(String id) {
        List<Address> addresses = addressRepository.findByCustomerId(id);
        List<GetAddressResponse> getAddressResponseList =
                addresses.stream().map(AddressMapper.INSTANCE::getAddressResponseFromAddress).collect(Collectors.toList());

        return getAddressResponseList;
    }
    @Override
    public CreatedAddressResponse add(CreateAddressRequest createAddressRequest) {

        Address address =
                AddressMapper.INSTANCE.addressFromCreateAddressRequest(createAddressRequest);

        Address createdAddress = addressRepository.save(address);

        CreatedAddressResponse createdAddressResponse =
                AddressMapper.INSTANCE.createdAddressResponseFromAddress(createdAddress);

        return  createdAddressResponse;
    }

    @Override
    public UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest, String id) {

        Address address =
                AddressMapper.INSTANCE.addressFromUpdateAddressRequest(updateAddressRequest);

        addressBusinessRules.checkIfAddressDeleted(address.getDeletedDate());
        address.setId(id);
        address.setUpdatedDate(LocalDateTime.now());
        Address updatedAddress = addressRepository.save(address);

        UpdatedAddressResponse updatedAddressResponse =
                AddressMapper.INSTANCE.updatedAddressResponseFromAddress(updatedAddress);

        return updatedAddressResponse;
    }

    @Override
    public DeletedAddressResponse delete(String id) {
        Address address = addressRepository.findById(id).get();
        addressBusinessRules.checkIfAddressDeleted(address.getDeletedDate());
        address.setId(id);
        address.setDeletedDate(LocalDateTime.now());
        Address deletedAddress = addressRepository.save(address);

        DeletedAddressResponse deletedAddressResponse = AddressMapper.INSTANCE.deletedAddressResponseFromAddress(deletedAddress);
        deletedAddressResponse.setDeletedDate(deletedAddress.getDeletedDate());
        return deletedAddressResponse;
    }

}
