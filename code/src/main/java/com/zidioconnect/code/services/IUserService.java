package com.zidioconnect.code.services;

import com.zidioconnect.code.models.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserById(long id);
    User create(User user);
    User update(User user);
    User deleteUserById(long id);
    User getUserByEmail(String email);
}
