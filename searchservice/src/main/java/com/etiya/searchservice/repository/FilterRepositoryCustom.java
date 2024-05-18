package com.etiya.searchservice.repository;

import com.etiya.searchservice.entities.Customer;

import java.util.List;

public interface FilterRepositoryCustom {
    List<Customer> searchResult(String nationalityIdentity, String id, String mobilePhone,
                                String accountNumber, String firstName, String lastName, String orderNumber);
}
