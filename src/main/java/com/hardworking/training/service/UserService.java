package com.hardworking.training.service;

import com.hardworking.training.model.Role;
import com.hardworking.training.model.User;
import com.hardworking.training.repository.RoleDao;
import com.hardworking.training.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    @Autowired
    @Qualifier("True")
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    public User getUserByCredentials(String email, String password) throws Exception{
        return userDao.getUserByCredentials(email,password);
    }

    public User getUserById(Long id){return userDao.getUserById(id);}

    public User saveUser(User user){return userDao.save(user);}

    public User update(User user){return userDao.update(user);}

    public boolean deleteUser(String name){return userDao.delete(name);}

    public User setRole(String userName,String roleName){
        User user=userDao.getUserByName(userName);
        List<Role> roles =user.getRoles();
        if (roleDao.getRoleByName(roleName)==null){
            System.out.println("Failed to get the role");
        }
        roles.add(roleDao.getRoleByName(roleName));
        user.setRoles(roles);
        userDao.update(user);
        return user;
    }
    public User removeRole(String userName,String roleName){
        User user=userDao.getUserByName(userName);
        List<Role> roles =new ArrayList<>();
        roles=user.getRoles();
        if (roleDao.getRoleByName(roleName)==null){
            System.out.println("Failed to get the role");
        }
        Role role =roleDao.getRoleByName(roleName);
        roles.remove(role);
        user.setRoles(roles);
        userDao.update(user);
        return user;
    }

}
