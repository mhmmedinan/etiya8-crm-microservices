package com.etiya.searchservice.service.concretes;

import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.repository.FilterRepository;
import com.etiya.searchservice.service.abstracts.FilterService;
import com.etiya.searchservice.service.dtos.responses.SearchResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {
    private FilterRepository filterRepository;

    @Override
    public void addCustomer(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public Customer getById(String id) {
        Customer customer = filterRepository.findById(id).get();
        return customer;
    }

    @Override
    public List<SearchResponse> getAll() {

        List<Customer> customerList = filterRepository.findAllByDeletedDateIsNull();

        List<SearchResponse> searchResponses = new ArrayList<>();
        for (Customer customer : customerList) {
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.setId(customer.getId());
            searchResponse.setFirstName(customer.getFirstName());
            searchResponse.setMiddleName(customer.getMiddleName());
            searchResponse.setLastName(customer.getLastName());
            searchResponse.setRole(customer.getRole());
            searchResponse.setNationalityIdentity(customer.getNationalityIdentity());
            searchResponse.setAccountNumber(customer.getAccountNumber());
            searchResponse.setMobilePhone(customer.getMobilePhone());

            searchResponses.add(searchResponse);
        }
        return searchResponses;
    }

    @Override
    public List<SearchResponse> search(
            String nationalityIdentity,
            String id,
            String accountNumber,
            String mobilePhone,
            String firstName,
            String lastName,
            String orderNumber) {

        List<Customer> customers =
                this.filterRepository.searchResult(
                        nationalityIdentity, id, mobilePhone, accountNumber, firstName, lastName, orderNumber
                );
        List<SearchResponse> searchResponses = new ArrayList<>();

        for (Customer customer : customers) {
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.setId(customer.getId());
            searchResponse.setFirstName(customer.getFirstName());
            searchResponse.setMiddleName(customer.getMiddleName());
            searchResponse.setLastName(customer.getLastName());
            searchResponse.setRole(customer.getRole());
            searchResponse.setNationalityIdentity(customer.getNationalityIdentity());
            searchResponse.setAccountNumber(customer.getAccountNumber());
            searchResponse.setMobilePhone(customer.getMobilePhone());

            searchResponses.add(searchResponse);
        }
        return searchResponses;
    }
}