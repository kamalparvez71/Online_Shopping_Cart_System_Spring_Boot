
package com.idb.evedience.repo;

import com.idb.evedience.entity.Products;
import com.idb.evedience.entity.Users;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<Users, Long>{
    
}
