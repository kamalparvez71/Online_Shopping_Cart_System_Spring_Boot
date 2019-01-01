package com.idb.evedience.service;

import com.idb.evedience.entity.Orders;
import java.util.List;

public interface OrderService {

    Orders save(Orders order);

    Orders get(long id);

    List<Orders> list();

    Orders update(Orders updateOrder);

    boolean delete(long id);


}
