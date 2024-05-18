package com.etiyacrm.customerservice.services.messages;

public class Messages {
    public static class BusinessErrors{
        public static final String CityNameExists ="cityNameExists";
        public static final String CityDeleted="cityDeleted";
        public static final String AddressDeleted="addressDeleted";

        public static final String IndividualCustomerDeleted="individualCustomerDeleted";
        public static final String NationalityIdentityExists = "nationalityIdentityExists";
        public static final String IndividualCustomerIdNotExists = "individualCustomerIdNotExists";
        public static final String IdentityNumberNotExists = "identityNumberNotExists";

        public static final String CustomerHasContactMedium = "customerHasContactMedium";
        public static final String CustomerHasNoContactMedium = "customerHasNoContactMedium";

        public static final String AddressNotExistsOnCustomer = "addressNotExistsOnCustomer";
    }
}