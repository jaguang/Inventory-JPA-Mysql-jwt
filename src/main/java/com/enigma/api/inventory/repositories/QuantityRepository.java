package com.enigma.api.inventory.repositories;

import com.enigma.api.inventory.entities.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface QuantityRepository extends JpaRepository<Quantity, Integer>, QuantitySummaryRepository {

}
