package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.CreateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests.UpdateBillingAccountRequest;
import com.etiyacrm.customerservice.services.dtos.responses.billingAccountResponses.*;

import java.util.List;

public interface BillingAccountService {
    PageInfoResponse<GetAllBillingAccountResponse> getAllPage(PageInfo pageInfo);
    List<GetAllBillingAccountResponse> getAll();
    List<GetBillingAccountResponse> getById(String id);
    CreatedBillingAccountResponse add(CreateBillingAccountRequest createBillingAccountRequest);
    UpdatedBillingAccountResponse update(UpdateBillingAccountRequest updateBillingAccountRequest, String id);
    DeletedBillingAccountResponse delete(String id);
}
