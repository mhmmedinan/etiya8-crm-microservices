package com.etiyacrm.customerservice.adapters;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;

public interface CustomerCheckService {
    public boolean checkIfRealPerson(String nationalityIdentity,
                                     String firstName,
                                     String lastName,
                                     int birthDate) throws Exception;
}
