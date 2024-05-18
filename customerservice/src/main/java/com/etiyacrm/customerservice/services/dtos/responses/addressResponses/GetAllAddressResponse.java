package com.etiyacrm.customerservice.services.dtos.responses.addressResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllAddressResponse {
    private String id;
    private String description;
    private String street;
    private int flatNumber;
    private boolean defaultAddress;
    private String districtId;
    private String customerId;
}
