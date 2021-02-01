package com.service.restservice.controller;

import com.service.restservice.impl.ControllerImpl;
import com.service.restservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/customer")
public class Controller {

    public ControllerImpl controllerImpl;

    @Autowired
    public Controller(ControllerImpl controllerImpl) {
        this.controllerImpl = controllerImpl;
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomer(){
        List<Customer> customerList = controllerImpl.getAllCustomers();
        return new ResponseEntity<>(customerList, OK);
    }

    @GetMapping("{customerId}/customer")
    public ResponseEntity<?> getCustomer(@PathVariable("customerId") int customerId){
        Map<Integer,Integer> set = new HashMap<>();
        Optional<Customer> customer = controllerImpl.getCustomerWithID(customerId);

        if(customer.isPresent()){
            return new ResponseEntity<>(customer, OK);
        }
        return new ResponseEntity<>("",OK);
    }

    public int[] sortedSquares(int[] A) {
        return Arrays.stream(A).map(val -> (int) Math.sqrt(val)).sorted().toArray();


    }
}
