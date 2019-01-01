
package com.idb.evedience.serviceimpl;

import com.google.common.collect.Lists;
import com.idb.evedience.entity.Users;
import com.idb.evedience.repo.UserRepo;
import com.idb.evedience.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
@Autowired
UserRepo userRepo;
    @Override
    public Users save(Users user) {
        Users createUsers=userRepo.save(user);
        return createUsers;
    }

    @Override
    public Users get(long id) {
        Users user=userRepo.findById(id).get();
        return user;
    }


  @Override
    public List<Users> list() {
      Iterable<Users> userList=userRepo.findAll();
      return Lists.newArrayList(userList);
    }
    @Override
    public Users update(Users updateUsers) {
        Users user=userRepo.save(updateUsers);
        return user;
    }

    @Override
    public boolean delete(long id) {
              userRepo.deleteById(id);
        Users user=userRepo.findById(id).get();
        if (user==null) {
            return Boolean.TRUE;         
        }else{
            return Boolean.FALSE;
        }
    }

    @Override
    public Users get(String userName, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
