package com.amigoscode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ){

    }

    record UpdateCustomerRequest(
            String name,
            String email,
            Integer age
    ){

    }
    // For Reading Customers API
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    // For Creating Customers API
    public void addCustomer(NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);

    }

    // For Deleting Customers API
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }

    // For Editing the Existing Customers API
    public void updateCustomer(Customer cust){
        Customer customer = customerRepository.findById(cust.getId())
                .orElseThrow(() -> new IllegalStateException("Customer with id " + cust.getId() + " not found"));
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }
}
