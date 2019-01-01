package com.idb.evedience.service;

import com.idb.evedience.entity.Customers;
import java.util.List;

public interface CustomerService{

    Customers save(Customers customer);

    Customers get(long id);

    List<Customers> list();

    Customers update(Customers updateCustomer);

    boolean delete(long id);



}
