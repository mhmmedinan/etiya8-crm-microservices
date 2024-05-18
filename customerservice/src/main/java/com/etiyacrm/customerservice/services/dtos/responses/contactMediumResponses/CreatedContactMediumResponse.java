package com.etiyacrm.customerservice.services.dtos.responses.contactMediumResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedContactMediumResponse {
    private String id;
    private String email;
    private String mobilePhone;
    private String homePhone;
    private String fax;
    private String customerId;
}
