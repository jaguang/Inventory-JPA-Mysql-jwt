package com.enigma.api.inventory.services.impl;

import com.enigma.api.inventory.entities.Transaction;
import com.enigma.api.inventory.repositories.TransactionRepository;
import com.enigma.api.inventory.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TransactionServiceImpl extends CommonServiceImpl<Transaction, Integer> implements TransactionService {

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        super(transactionRepository);
    }

}
