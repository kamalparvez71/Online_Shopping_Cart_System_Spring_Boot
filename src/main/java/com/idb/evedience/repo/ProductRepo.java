
package com.idb.evedience.repo;

import com.idb.evedience.entity.Products;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepo extends CrudRepository<Products, Integer>{
    
}
