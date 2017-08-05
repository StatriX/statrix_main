package com.statrix.rest.service;

import com.statrix.rest.models.Users;

import java.util.List;

public interface UserService {

    Users findById(long id);

    Users findByName(String name);

    void saveUser(Users user);

    void updateUser(Users user);

    void deleteUserById(long id);

    List<Users> findAllUsers();

    void deleteAllUsers();

    boolean isUserExist(Users user);
}
