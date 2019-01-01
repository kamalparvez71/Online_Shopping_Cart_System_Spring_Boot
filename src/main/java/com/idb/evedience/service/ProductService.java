package com.idb.evedience.service;

import com.idb.evedience.entity.Products;
import java.util.List;

public interface ProductService {

    Products save(Products product);

    Products get(Integer id);

    List<Products> list();

    Products update(Products updateproduct);

    boolean delete(Integer id);

}
