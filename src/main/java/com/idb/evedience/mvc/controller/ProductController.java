package com.idb.evedience.mvc.controller;

import com.idb.evedience.entity.Products;
import com.idb.evedience.service.ProductService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getAllProduct(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAttribute("products", productService.list());
        modelMap.addAttribute("sm", request.getParameter("sm"));
        modelMap.addAttribute("em", request.getParameter("em"));
        return "product";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String saveProduct(ModelMap modelMap, HttpServletRequest request) {
        Products product = new Products();
        product.setPname(request.getParameter("pname"));
        product.setPprice(Double.parseDouble(request.getParameter("price")));
        product.setPquantity(Integer.parseInt(request.getParameter("qty")));
        Products status = productService.save(product);
        if (status!=null) {
            modelMap.addAttribute("sm", "Product Info Saved Successfully");
        } else {
            modelMap.addAttribute("em", "Product Info Not Saved");
        }
        return "redirect:/product";
    }

    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable("id") String id, ModelMap modelMap) {
        Products product = productService.get(Integer.parseInt(id));
        modelMap.addAttribute("product", product);
        modelMap.addAttribute("products", productService.list());
        return "product";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProduct(ModelMap modelMap, HttpServletRequest request) {
        Products product = new Products();
        product.setPid(Integer.parseInt(request.getParameter("pid")));
        product.setPname(request.getParameter("pname"));
        product.setPprice(Double.parseDouble(request.getParameter("price")));
        product.setPquantity(Integer.parseInt(request.getParameter("qty")));
        Products status = productService.update(product);
        if (status!=null) {
            modelMap.addAttribute("sm", "Product Info Update Successfully");
        } else {
            modelMap.addAttribute("em", "Product Info Not Update");
        }
        return "redirect:/product";
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") String id, ModelMap modelMap) {
        boolean status = productService.delete(Integer.parseInt(id));
        if (status) {
            modelMap.addAttribute("sm", "Product Info Deleted Successfully");
        } else {
            modelMap.addAttribute("em", "Product Info Not Delete");
        }
        return "redirect:/product";
    }
    
}
