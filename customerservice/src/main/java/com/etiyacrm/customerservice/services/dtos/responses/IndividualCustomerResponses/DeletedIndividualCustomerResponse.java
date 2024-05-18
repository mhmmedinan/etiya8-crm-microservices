package com.etiyacrm.customerservice.services.dtos.responses.IndividualCustomerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedIndividualCustomerResponse {
    private String id;
    private LocalDateTime deletedDate;
}
