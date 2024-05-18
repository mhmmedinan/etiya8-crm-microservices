package com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateContactMediumRequest {

    @NotBlank
    private String email;

    @NotBlank
    //@Pattern(regexp = "/([(]?)([5])([0-9]{2})([)]?)([\\s]?)([0-9]{3})([\\s]?)([0-9]{2})([\\s]?)([0-9]{2})$/g")
    private String mobilePhone;

    @NotNull
    private String homePhone;

    @NotNull
    private String fax;

}
