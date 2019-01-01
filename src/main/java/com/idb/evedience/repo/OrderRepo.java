
package com.idb.evedience.repo;

import com.idb.evedience.entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Orders, Long>{
    
}
