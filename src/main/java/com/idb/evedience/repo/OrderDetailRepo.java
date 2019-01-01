
package com.idb.evedience.repo;

import com.idb.evedience.entity.OrderDetails;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepo extends CrudRepository<OrderDetails, Long>{
    
}
