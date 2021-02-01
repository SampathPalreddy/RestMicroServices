package com.service.restservice.impl;

import com.service.restservice.model.Customer;
import com.service.restservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ControllerImpl {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(int id){
        return customerRepository.findById(id);
    }
}
