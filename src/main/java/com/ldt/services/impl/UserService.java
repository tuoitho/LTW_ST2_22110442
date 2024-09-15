package com.ldt.services.impl;

import com.ldt.dao.IUserDao;
import com.ldt.dao.impl.UserDaoImpl;
import com.ldt.models.UserModel;
import com.ldt.services.IUserService;

public class UserService implements IUserService {
//    lay all ham trong tang Dao of user
    IUserDao userDao=new UserDaoImpl();
    @Override
    public UserModel login(String username, String password) {
        UserModel user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public UserModel findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
