package com.enigma.api.inventory.repositories;

import com.enigma.api.inventory.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "SELECT id FROM customer ORDER BY rand() lIMIT 1", nativeQuery = true)
    List<Customer> findCustomerIdByRandom();
}
