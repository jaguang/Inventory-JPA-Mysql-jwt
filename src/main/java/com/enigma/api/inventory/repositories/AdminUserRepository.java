package com.enigma.api.inventory.repositories;

import com.enigma.api.inventory.entities.AmindUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends CrudRepository<AmindUser, Integer> {
	
	AmindUser findByUsername(String username);
	
}