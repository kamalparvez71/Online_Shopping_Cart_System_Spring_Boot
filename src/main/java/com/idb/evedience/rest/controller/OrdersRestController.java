package com.idb.evedience.rest.controller;

import com.idb.evedience.entity.Orders;
import com.idb.evedience.service.OrderService;
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
@RequestMapping(path = "api/orders", produces = {"application/json"})
public class OrdersRestController {

static final Logger logger = LogManager.getLogger(OrdersRestController.class);

        @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public Orders addOrders(@RequestBody Orders order) {
        System.out.println("Adding order with ID: " + order.getOid());
        Orders createOrders = orderService.save(order);
        return createOrders;
    }
 @GetMapping("{id}")
    public List<Orders> getAllOrderss() {
        System.out.println("Getting all orders..");
        List<Orders> orderList = orderService.list();
        return orderList;
    }
    
    
    @PutMapping("/{id}")
    public Orders updateOrders(@RequestBody Orders order) {
        Orders updateOrders = orderService.update(order);
        return updateOrders;
    }

    @GetMapping("/search/{query}")
    public ArrayList<Orders> searchOrdersByName(@PathVariable("query") String query) {
        System.out.println("Searching order by Name: " + query);

        ArrayList<Orders> orderList = new ArrayList<Orders>();

        return orderList;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteOrdersById(@PathVariable("id") Long id) {
        System.out.println("Deleting order with ID: " + id);

Boolean isDeleteOrders=orderService.delete(id);
 if (isDeleteOrders) {
           logger.info("Inside deleteOrdersById, returned: " );
        } else {
           logger.info("Inside deleteOrdersById, ID: " + id + ", NOT FOUND!");
       }
        return isDeleteOrders;
    }
    
}
