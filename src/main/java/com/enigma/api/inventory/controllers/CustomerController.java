package com.enigma.api.inventory.controllers;

import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.models.*;
import com.enigma.api.inventory.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private ModelMapper modelMapper;

    @PutMapping("/{id}")
    public ResponseMessage<CustomerResponse> edit(@PathVariable Integer id, @RequestBody @Valid CustomerRequest model) {

        Customer entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        modelMapper.map(model, entity);
        service.save(entity);

        CustomerResponse data = modelMapper.map(entity, CustomerResponse.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<CustomerResponse> removeById(@PathVariable Integer id) {
        Customer entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        ModelMapper modelMapper = new ModelMapper();
        CustomerResponse data = modelMapper.map(entity, CustomerResponse.class);

        return ResponseMessage.success(data);
    }

    @PostMapping
    public ResponseMessage<CustomerResponse> add(@RequestBody @Valid CustomerRequest model) {
        Customer entity = modelMapper.map(model, Customer.class);
        entity = service.save(entity);
        CustomerResponse data = modelMapper.map(entity, CustomerResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<CustomerResponse> findById(@PathVariable Integer id) {
        Customer entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        ModelMapper modelMapper = new ModelMapper();
        CustomerResponse data = modelMapper.map(entity, CustomerResponse.class);

        return ResponseMessage.success(data);
    }


    @GetMapping
    public ResponseMessage<PagedList<CustomerResponse>> findAll(
            @Valid CustomerSearch model
    ) {
        Customer search = modelMapper.map(model, Customer.class);

        Page<Customer> entityPage = service.findAll(search, model.getPage(), model.getSize(), model.getSort());

        List<Customer> entities = entityPage.toList();

        List<CustomerResponse> models = entities.stream()
                .map(e -> modelMapper.map(e, CustomerResponse.class))
                .collect(Collectors.toList());

        PagedList<CustomerResponse> data = new PagedList<>(models,
                entityPage.getNumber(),
                entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

}
