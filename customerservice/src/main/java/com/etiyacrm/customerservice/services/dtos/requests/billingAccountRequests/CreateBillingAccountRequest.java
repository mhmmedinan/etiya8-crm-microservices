package com.etiyacrm.customerservice.services.dtos.requests.billingAccountRequests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBillingAccountRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String accountNumber;

    @NotBlank
    private String type;

    private String customerId;

    private String addressId;
}
