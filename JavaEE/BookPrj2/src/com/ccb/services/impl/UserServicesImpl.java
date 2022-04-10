package com.ccb.services.impl;

import com.ccb.dao.UserDao;
import com.ccb.dao.impl.UserDaoImpl;
import com.ccb.entity.User;
import com.ccb.services.UserServices;

public class UserServicesImpl implements UserServices {
    UserDao dao = new UserDaoImpl();
    @Override
    public void register(User user) {
        dao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return dao.queryUser(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean isExitUser(String username) {
        if(dao.queryUser(username) != null){
            return true;
        }
        return false;
    }
}
