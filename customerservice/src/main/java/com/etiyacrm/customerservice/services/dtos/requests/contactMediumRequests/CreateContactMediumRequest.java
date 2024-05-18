package com.etiyacrm.customerservice.services.dtos.requests.contactMediumRequests;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactMediumRequest {

    @NotBlank
    private String email;

    @NotBlank
    //@Pattern(regexp = "([(]?)([5])([0-9]{2})([)]?)([\\s]?)([0-9]{3})([\\s]?)([0-9]{2})([\\s]?)([0-9]{2})$")
    private String mobilePhone;

    @NotNull
    private String homePhone;

    @NotNull
    private String fax;

    @NotBlank
    private String customerId;
}
