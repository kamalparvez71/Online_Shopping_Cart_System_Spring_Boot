package com.idb.evedience.rest.controller;

import com.idb.evedience.entity.OrderDetails;
import com.idb.evedience.service.OrderDetailService;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/orderdetails", produces = {"application/json"})
public class OrderDetailsRestController {
  
     static final Logger logger = LogManager.getLogger(OrderDetailsRestController.class);

        @Autowired
    OrderDetailService orderDetailsService;

    @PostMapping("/add")
    public OrderDetails addOrderDetails(@RequestBody OrderDetails orderDetails) {
        System.out.println("Adding orderDetails with ID: " + orderDetails.getPid());
        OrderDetails createOrderDetails = orderDetailsService.save(orderDetails);
        return createOrderDetails;
    }
 @GetMapping("{id}")
    public List<OrderDetails> getAllOrderDetails() {
        System.out.println("Getting all orderDetails..");
        List<OrderDetails> orderDetailsList = orderDetailsService.list();
        return orderDetailsList;
    }
    
    
    @PutMapping("/{id}")
    public OrderDetails updateOrderDetails(@RequestBody OrderDetails orderDetails) {
        OrderDetails updateOrderDetails = orderDetailsService.update(orderDetails);
        return updateOrderDetails;
    }

    @GetMapping("/search/{query}")
    public ArrayList<OrderDetails> searchOrderDetailsByName(@PathVariable("query") String query) {
        System.out.println("Searching orderDetails by Name: " + query);

        ArrayList<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();

        return orderDetailsList;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteOrderDetailsById(@PathVariable("id") Long id) {
        System.out.println("Deleting orderDetails with ID: " + id);

Boolean isDeleteOrderDetails=orderDetailsService.delete(id);
 if (isDeleteOrderDetails) {
           logger.info("Inside deleteOrderDetailsById, returned: " );
        } else {
           logger.info("Inside deleteOrderDetailsById, ID: " + id + ", NOT FOUND!");
       }
        return isDeleteOrderDetails;
    }
}
