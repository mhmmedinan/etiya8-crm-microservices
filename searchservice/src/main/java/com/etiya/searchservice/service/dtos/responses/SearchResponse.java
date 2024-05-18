package com.etiya.searchservice.service.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String role;
    private String nationalityIdentity;
    private String accountNumber;
    private String mobilePhone;
}    

