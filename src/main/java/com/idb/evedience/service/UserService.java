package com.idb.evedience.service;

import com.idb.evedience.entity.Users;
import java.util.List;

public interface UserService {

    Users save(Users user);

    Users get(long id);

    List<Users> list();

    Users update(Users updateperson);

    boolean delete(long id);

    public Users get(String userName, String password);

}
