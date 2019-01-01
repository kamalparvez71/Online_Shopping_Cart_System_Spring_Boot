
package com.idb.evedience.mvc.controller;

import com.idb.evedience.repo.OrderDetailRepo;
import com.idb.evedience.service.CustomerService;
import com.idb.evedience.service.OrderDetailService;
import com.idb.evedience.service.OrderService;
import com.idb.evedience.service.ProductService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping(value = "/indexcustomer", method = RequestMethod.GET)
    public String indexPage(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAttribute("orderNo", orderDetailService.get(1));
        modelMap.addAttribute("products", productService.list());
        modelMap.addAttribute("customers", customerService.list());
        modelMap.addAttribute("em", request.getParameter("em"));
        return "indexcustomer";
    }
    
}
