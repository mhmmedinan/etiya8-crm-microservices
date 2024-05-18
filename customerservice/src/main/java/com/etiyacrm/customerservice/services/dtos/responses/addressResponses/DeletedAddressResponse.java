package com.etiyacrm.customerservice.services.dtos.responses.addressResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedAddressResponse {
    private String id;
    private LocalDateTime deletedDate;
}
