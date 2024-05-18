package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.cityresponses.*;

import java.util.List;

public interface CityService {
    PageInfoResponse<GetAllCityResponse> getAllPage(PageInfo pageInfo);
    GetCityResponse getById(String id);
    CreatedCityResponse add(CreateCityRequest createCityRequest);
    UpdatedCityResponse update(UpdateCityRequest updateCityRequest, String id);
    DeletedCityResponse delete(String id);

    List<GetAllCityResponse> getAll();
}
