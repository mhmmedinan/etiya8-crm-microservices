package com.etiya.searchservice.service.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    String nationalityIdentity;
    String id;
    String accountNumber;
    String mobilePhone;
    String firstName;
    String lastName;
    String orderNumber;
}
