package com.hardworking.training.repository;

import com.hardworking.training.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("Fake")
public class UserFakeDaoImpl implements UserDao {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public boolean delete(String name) {
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByCredentials(String email, String password) throws Exception {
        return null;
    }
}
