package com.etiyacrm.customerservice.services.dtos.responses.billingAccountResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedBillingAccountResponse {
    private String id;
    private String status;
    private String accountNumber;
    private String name;
    private String type;
    private String customerId;
    private String addressId;
}
