
package com.idb.evedience.serviceimpl;

import com.google.common.collect.Lists;
import com.idb.evedience.entity.Orders;
import com.idb.evedience.entity.Users;
import com.idb.evedience.repo.OrderRepo;
import com.idb.evedience.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderServiceImpl implements OrderService {
@Autowired
OrderRepo orderRepo;
    @Override
    public Orders save(Orders order) {
        Orders createOrders=orderRepo.save(order);
        return createOrders;
    }

    @Override
    public Orders get(long id) {
        Orders order=orderRepo.findById(id).get();
        return order;
    }


  @Override
    public List<Orders> list() {
      Iterable<Orders> orderList=orderRepo.findAll();
      return Lists.newArrayList(orderList);
    }
    @Override
    public Orders update(Orders updateOrders) {
        Orders order=orderRepo.save(updateOrders);
        return order;
    }

    @Override
    public boolean delete(long id) {
              orderRepo.deleteById(id);
        Orders order=orderRepo.findById(id).get();
        if (order==null) {
            return Boolean.TRUE;         
        }else{
            return Boolean.FALSE;
        }
    }
    
}
