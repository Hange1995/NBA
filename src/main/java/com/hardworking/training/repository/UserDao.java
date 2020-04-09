package com.hardworking.training.repository;

import com.hardworking.training.model.Player;
import com.hardworking.training.model.User;

import java.util.List;

public interface UserDao {
    User save(User user);
    List<User> getUsers();
    boolean delete(String name);
    User update(User user);
    User getUserByName(String name);
    User getUserById(Long id);
    User getUserByCredentials(String email, String password) throws Exception;
}
