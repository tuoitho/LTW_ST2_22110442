package com.ldt.services;

import com.ldt.models.UserModel;

public interface IUserService {
    UserModel login(String username, String password);
    UserModel findByUsername(String username);
}
