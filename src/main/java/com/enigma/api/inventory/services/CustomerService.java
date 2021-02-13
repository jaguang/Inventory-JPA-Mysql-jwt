package com.enigma.api.inventory.services;

import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface CustomerService extends CommonService<Customer,Integer> {

    List<Customer> findCustomerIdByRandom();
}
