package com.techelevator.useless_dungeon.dao;

import com.techelevator.useless_dungeon.model.security.RegisterUserDto;
import com.techelevator.useless_dungeon.model.security.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
