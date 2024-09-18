package com.ldt.services;

import com.ldt.models.UserModel;

public interface IUserService {
    UserModel login(String username, String password);
    UserModel findByUsername(String username);
    UserModel findByEmail(String email);
    UserModel register(String username, String password, String email, int role);

    UserModel updatePassword(String email, String password);
}
