package com.ldt.dao;

import com.ldt.models.UserModel;

import java.util.List;

public interface IUserDao {
    List<UserModel> findAll();
    UserModel findById(int id);
    void insert(UserModel user);
    UserModel findByUsername(String username);
}
