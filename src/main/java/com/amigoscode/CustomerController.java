package com.amigoscode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // For Reading Customers API
    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    // For Creating Customers API
    @PostMapping
    public void addCustomer(@RequestBody CustomerService.NewCustomerRequest customer){
         customerService.addCustomer(customer);

    }

    // For Deleting Customers API
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerService.deleteCustomer(id);
    }

    // For Editing the Existing Customers API
    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id,
                               @RequestBody Customer cust){

        customerService.updateCustomer(cust);
    }
}
