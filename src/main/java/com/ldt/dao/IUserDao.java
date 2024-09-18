package com.ldt.dao;

import com.ldt.models.UserModel;

import java.util.List;

public interface IUserDao {
    List<UserModel> findAll();
    UserModel findById(int id);
    UserModel insert(UserModel user);
    UserModel findByUsername(String username);

    UserModel findByEmail(String email);
    UserModel update(UserModel user, String password);
}
