package com.etiyacrm.customerservice.services.dtos.responses.billingAccountResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedBillingAccountResponse {
    private String id;
    private LocalDateTime deletedDate;
}
