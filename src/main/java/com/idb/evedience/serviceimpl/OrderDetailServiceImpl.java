
package com.idb.evedience.serviceimpl;

import com.google.common.collect.Lists;
import com.idb.evedience.entity.OrderDetails;
import com.idb.evedience.entity.OrderDetails;
import com.idb.evedience.repo.OrderDetailRepo;
import com.idb.evedience.service.OrderDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
@Autowired
OrderDetailRepo orderDetailRepo;
    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        OrderDetails createOrderDetails=orderDetailRepo.save(orderDetails);
        return createOrderDetails;
    }

    @Override
    public OrderDetails get(long id) {
        OrderDetails orderDetails=orderDetailRepo.findById(id).get();
        return orderDetails;
    }


  @Override
    public List<OrderDetails> list() {
      Iterable<OrderDetails> orderDetailsList=orderDetailRepo.findAll();
      return Lists.newArrayList(orderDetailsList);
    }
    @Override
    public OrderDetails update(OrderDetails updateOrderDetails) {
        OrderDetails orderDetails=orderDetailRepo.save(updateOrderDetails);
        return orderDetails;
    }

    @Override
    public boolean delete(long id) {
              orderDetailRepo.deleteById(id);
        OrderDetails orderDetails=orderDetailRepo.findById(id).get();
        if (orderDetails==null) {
            return Boolean.TRUE;         
        }else{
            return Boolean.FALSE;
        }
    }
}
