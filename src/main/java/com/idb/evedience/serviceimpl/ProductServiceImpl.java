
package com.idb.evedience.serviceimpl;

import com.google.common.collect.Lists;
import com.idb.evedience.entity.Products;
import com.idb.evedience.repo.ProductRepo;
import com.idb.evedience.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
ProductRepo productRepo;
    @Override
    public Products save(Products product) {
        Products createProduct=productRepo.save(product);
        return createProduct;
    }

    @Override
    public Products get(Integer id) {
        Products product=productRepo.findById(id).get();
        return product;
    }


  @Override
    public List<Products> list() {
      Iterable<Products> productList=productRepo.findAll();
      return Lists.newArrayList(productList);
    }
    @Override
    public Products update(Products updateProduct) {
        Products product=productRepo.save(updateProduct);
        return product;
    }

    @Override
    public boolean delete(Integer id) {
              productRepo.deleteById(id);
        Products product=productRepo.findById(id).get();
        if (product==null) {
            return Boolean.TRUE;         
        }else{
            return Boolean.FALSE;
        }
    }
}
