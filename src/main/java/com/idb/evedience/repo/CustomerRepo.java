
package com.idb.evedience.repo;

import com.idb.evedience.entity.Customers;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepo extends CrudRepository<Customers, Long> {
    
}
