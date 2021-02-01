package com.service.restservice.impl;

import com.service.restservice.model.Customer;
import com.service.restservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ControllerImpl {


    public ControllerImpl() {
        this.customersList = getCustomersList();
    }

    private final List<Customer> customersList;

    public List<Customer> getCustomersList(){
        List<Customer> customersList = new ArrayList<>();
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setName("Goutham");
        customer.setSalary(10000);

        Customer customer2 = new Customer();
        customer2.setCustomerId(2);
        customer2.setName("Karthik");
        customer2.setSalary(9000);

        Customer customer3 = new Customer();
        customer3.setCustomerId(3);
        customer3.setName("Sampath");
        customer3.setSalary(5000);

        Customer customer4 = new Customer();
        customer4.setCustomerId(4);
        customer4.setName("Sai");
        customer4.setSalary(12000);

        Customer customer5 = new Customer();
        customer5.setCustomerId(5);
        customer5.setName("Manoj");
        customer5.setSalary(123);

        customersList.add(customer);
        customersList.add(customer2);
        customersList.add(customer3);
        customersList.add(customer4);
        customersList.add(customer5);
        return customersList;
    }


    public List<Customer> getAllCustomers() {
        return customersList;
    }


    //1, return a customer with id 1
    public Optional<Customer> getCustomerWithID(int id){
       for(int i=0; i<customersList.size(); i++){
           Customer cus = customersList.get(i);
           if(cus.getCustomerId() == id){
               return Optional.of(cus);
           }
       }
       return Optional.empty();
    }

    //2, getCustomerWithName
    public Customer getCustomerWithName(String name){

    }

    //3, get All Customer who's salary is more then 10000
    public List<Customer> getCustomerWithSalary(int salary){

    }

    //4, check if there is customer with name
    public String checkForCustomer(String name){

    }

    //5, get All Customer who's salary is less then 10000


}
