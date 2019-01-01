
package com.idb.evedience.serviceimpl;

import com.google.common.collect.Lists;
import com.idb.evedience.entity.Customers;
import com.idb.evedience.repo.CustomerRepo;
import com.idb.evedience.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerServiceImpl implements CustomerService{
@Autowired
CustomerRepo customerRepo;
    @Override
    public Customers save(Customers customer) {
        Customers createCustomer=customerRepo.save(customer);
        return createCustomer;
    }

    @Override
    public Customers get(long id) {
        Customers customer=customerRepo.findById(id).get();
        return customer;
    }


  @Override
    public List<Customers> list() {
      Iterable<Customers> customerList=customerRepo.findAll();
      return Lists.newArrayList(customerList);
    }
    @Override
    public Customers update(Customers updateCustomer) {
        Customers customer=customerRepo.save(updateCustomer);
        return customer;
    }

    @Override
    public boolean delete(long id) {
              customerRepo.deleteById(id);
        Customers customer=customerRepo.findById(id).get();
        if (customer==null) {
            return Boolean.TRUE;         
        }else{
            return Boolean.FALSE;
        }
    }

  
}
