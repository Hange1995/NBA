package com.hardworking.training.service;

import com.hardworking.training.model.User;
import com.hardworking.training.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUserByCredentials(String email, String password) throws Exception{
        return userDao.getUserByCredentials(email,password);
    }

    public User getUserById(Long id){return userDao.getUserById(id);}

    public User saveUser(User user){return userDao.save(user);}

}
