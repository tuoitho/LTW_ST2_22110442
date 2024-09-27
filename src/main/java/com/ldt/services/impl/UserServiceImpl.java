package com.ldt.services.impl;

import com.ldt.dao.IUserDao;
import com.ldt.dao.impl.UserDaoImpl;
import com.ldt.models.UserModel;
import com.ldt.services.IUserService;

public class UserServiceImpl implements IUserService {
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

    @Override
    public UserModel findByEmail(String email) {
        return userDao.findByEmail(email);

    }

    @Override
    public UserModel register(String username, String password, String email, int role) {
        return userDao.insert(new UserModel(username, password, email,role));
    }

    @Override
    public UserModel updatePassword(String email,String password) {
        UserModel user = userDao.findByEmail(email);
        user.setPassword(password);
        return userDao.updatePassword(user,password);
    }

    @Override
    public UserModel updateProfile(UserModel user) {
        return null;
    }

    public static void main(String[] args) {
        try {
            IUserService userService = new UserServiceImpl();
            System.out.println(userService.login("trungnh", "1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
