package com.idb.evedience.rest.controller;


import com.idb.evedience.entity.Customers;
import com.idb.evedience.service.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/customers", produces = {"application/json"})
public class CustomerRestController {
static final Logger logger = LogManager.getLogger(CustomerRestController.class);

        @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public Customers addCustomer(@RequestBody Customers customer) {
        System.out.println("Adding customer with ID: " + customer.getCid());
        Customers createCustomer = customerService.save(customer);
        return createCustomer;
    }
 @GetMapping("{id}")
    public List<Customers> getAllCustomers() {
        System.out.println("Getting all customers..");
        List<Customers> customerList = customerService.list();
        return customerList;
    }
    
    
    @PutMapping("/{id}")
    public Customers updateCustomer(@RequestBody Customers updateCustomer) {
        Customers updateCustomer1 = customerService.update(updateCustomer);
        return updateCustomer1;
    }

    @GetMapping("/search/{query}")
    public ArrayList<Customers> searchCustomerByName(@PathVariable("query") String query) {
        System.out.println("Searching customer by Name: " + query);

        ArrayList<Customers> customerList = new ArrayList<Customers>();

        return customerList;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCustomerById(@PathVariable("id") Long id) {
        System.out.println("Deleting customer with ID: " + id);

Boolean isDeleteCustomer=customerService.delete(id);
 if (isDeleteCustomer) {
           logger.info("Inside deleteCustomerById, returned: " );
        } else {
           logger.info("Inside deleteCustomerById, ID: " + id + ", NOT FOUND!");
       }
        return isDeleteCustomer;
    }
}
