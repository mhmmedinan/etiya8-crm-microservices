package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.repositories.CustomerRepository;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    @Override
    public Customer getById(String id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }
}
