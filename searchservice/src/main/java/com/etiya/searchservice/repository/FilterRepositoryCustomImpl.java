package com.etiya.searchservice.repository;

import com.etiya.searchservice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FilterRepositoryCustomImpl implements FilterRepositoryCustom{
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Customer> searchResult
            (String nationalityIdentity, String id, String mobilePhone, String accountNumber, String firstName, String lastName, String orderNumber) {

        List<Criteria> criteriaList = new ArrayList<>();

        criteriaList.add(nationalityIdentity != null ? Criteria.where("nationalityIdentity").is(nationalityIdentity) : null);
        criteriaList.add(id != null && !id.isEmpty() ? Criteria.where("id").regex(id, "i") : null);
        criteriaList.add(mobilePhone != null ? Criteria.where("mobilePhone").is(mobilePhone) : null);
        criteriaList.add(accountNumber != null ? Criteria.where("accountNumber").is(accountNumber) : null);
        criteriaList.add(firstName != null && !firstName.isEmpty() ? Criteria.where("firstName").regex(firstName, "i") : null);
        criteriaList.add(lastName != null && !lastName.isEmpty() ? Criteria.where("lastName").regex(lastName, "i") : null);
        criteriaList.add(orderNumber != null ? Criteria.where("orderNumber").is(orderNumber) : null);

        criteriaList.removeIf(criteria -> criteria == null);

        criteriaList.add(Criteria.where("deletedDate").is(null));

        if (criteriaList.isEmpty()) {
            return mongoTemplate.findAll(Customer.class);
        }

        Query query = new Query();
        query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));

        return mongoTemplate.find(query, Customer.class);
    }
}