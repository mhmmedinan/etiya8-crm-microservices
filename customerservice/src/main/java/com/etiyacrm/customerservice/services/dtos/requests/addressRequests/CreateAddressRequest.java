package com.etiyacrm.customerservice.services.dtos.requests.addressRequests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressRequest {

    @NotEmpty
    @NotBlank
    @Size(min = 3,max = 250)
    private String description;

    @NotBlank
    private String street;

    @NotNull
    @Positive
    private int flatNumber;

    @NotNull
    private boolean defaultAddress;

    @NotBlank
    private String districtId;

    @NotBlank
    private String customerId;
}
