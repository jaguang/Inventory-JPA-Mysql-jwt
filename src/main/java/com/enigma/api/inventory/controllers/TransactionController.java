package com.enigma.api.inventory.controllers;

import com.enigma.api.inventory.entities.*;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.models.*;
import com.enigma.api.inventory.services.CustomerService;
import com.enigma.api.inventory.services.ItemService;
import com.enigma.api.inventory.services.QuantityService;
import com.enigma.api.inventory.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("/transactions")
@RestController
public class TransactionController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private QuantityService quantityService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransactionService transactionService;





}
