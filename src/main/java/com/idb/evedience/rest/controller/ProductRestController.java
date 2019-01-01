package com.idb.evedience.rest.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import com.idb.evedience.entity.Products;
import com.idb.evedience.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
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
@RequestMapping(path = "api/products", produces = {"application/json"})
public class ProductRestController {

    static final Logger logger = LogManager.getLogger(ProductRestController.class);

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Products addProduct(@RequestBody Products product) {
        System.out.println("Adding product with ID: " + product.getPid());
        Products createProduct = productService.save(product);
        return createProduct;
    }

    @GetMapping("/productlist")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Products> getAllProducts() {
        System.out.println("Getting all products..");
        List<Products> productList = productService.list();
        return productList;
    }

       @GetMapping("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Products> getAllProduct() {
        System.out.println("Getting all products..");
        List<Products> productList = productService.list();
        return productList;
    }
    
    @PutMapping("/{id}")
    public Products updateProduct(@RequestBody Products product) {
        Products updateProduct = productService.update(product);
        return updateProduct;
    }

    @GetMapping("/search/{query}")
    public ArrayList<Products> searchProductByName(@PathVariable("query") String query) {
        System.out.println("Searching product by Name: " + query);

        ArrayList<Products> productList = new ArrayList<Products>();

        return productList;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteProductById(@PathVariable("id") int id) {
        System.out.println("Deleting product with ID: " + id);

        Boolean isDeleteProduct = productService.delete(id);
        if (isDeleteProduct) {
            logger.info("Inside deleteProductById, returned: ");
        } else {
            logger.info("Inside deleteProductById, ID: " + id + ", NOT FOUND!");
        }
        return isDeleteProduct;
    }
}
