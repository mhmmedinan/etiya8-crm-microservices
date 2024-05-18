package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.addressRequests.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.addressResponses.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AddressService {
    PageInfoResponse<GetAllAddressResponse> getAllPage(PageInfo pageInfo);
    List<GetAddressResponse> getById(String id);
    CreatedAddressResponse add(CreateAddressRequest createAddressRequest);
    UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest, String id);
    DeletedAddressResponse delete(String id);
    List<GetAllAddressResponse> getAll();
}
