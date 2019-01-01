package com.idb.evedience.service;

import com.idb.evedience.entity.OrderDetails;
import com.idb.evedience.entity.Users;
import java.util.List;

public interface OrderDetailService {

    OrderDetails save(OrderDetails orderDetails);

  OrderDetails get(long id);

    List<OrderDetails> list();

    OrderDetails update(OrderDetails updateOrderDetails);

    boolean delete(long id);


}
