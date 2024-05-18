package com.etiya.searchservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "search-customer")
public class Customer {
    @Id
    private String id;

    @Field(name = "nationalityIdentity")
    private String nationalityIdentity;

    @Field(name = "accountNumber")
    private String accountNumber;

    @Field(name = "mobilePhone")
    private String mobilePhone;

    @Field(name = "firstName")
    private String firstName;

    @Field(name = "lastName")
    private String lastName;

    @Field(name = "middleName")
    private String middleName;

    @Field(name = "role")
    private String role;

    @Field(name = "orderNumber")
    private String orderNumber;

    @Field(name = "deletedDate")
    private LocalDateTime deletedDate;
}
