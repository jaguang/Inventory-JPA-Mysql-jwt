package com.enigma.api.inventory.services.impl;

import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.repositories.CustomerRepository;
import com.enigma.api.inventory.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class CustomerServiceImpl extends CommonServiceImpl<Customer, Integer> implements CustomerService {

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository);
    }

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> findCustomerIdByRandom() {
        return repository.findCustomerIdByRandom();
    }
}
