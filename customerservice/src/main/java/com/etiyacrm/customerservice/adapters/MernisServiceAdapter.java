package com.etiyacrm.customerservice.adapters;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.outservices.mernis.LWPKPSPublicSoap;
import org.apache.commons.lang.WordUtils;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements CustomerCheckService{
    @Override
    public boolean checkIfRealPerson(String nationalityIdentity,
                                     String firstName,
                                     String lastName,
                                     int birthDate) throws Exception {
        LWPKPSPublicSoap client = new LWPKPSPublicSoap();
        String formattedFirstName = firstName.toLowerCase();
        String formattedLastName = lastName.toLowerCase();
        formattedFirstName = WordUtils.capitalize(formattedFirstName);
        formattedLastName = WordUtils.capitalize(formattedLastName);
        return client.TCKimlikNoDogrula(
                Long.parseLong(nationalityIdentity),
                formattedFirstName,
                formattedLastName,
                birthDate);
    }
}
