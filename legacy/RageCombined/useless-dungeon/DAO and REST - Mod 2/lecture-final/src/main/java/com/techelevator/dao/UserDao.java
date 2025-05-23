package com.techelevator.dao;

import com.techelevator.model.security.RegisterUserDto;
import com.techelevator.model.security.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
