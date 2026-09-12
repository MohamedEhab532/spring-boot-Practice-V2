package com.amigoscode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
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
    public void deleteCustomer(Integer id){
        customerRepository.deleteById(id);
    }

    // For Editing the Existing Customers API
    public void updateCustomer(Integer id, Customer cust){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Customer with id " + id + " not found"));
        customer.setName(cust.getName());
        customer.setEmail(cust.getEmail());
        customer.setAge(cust.getAge());
        customerRepository.save(customer);
    }
}
