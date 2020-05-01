package com.hardworking.training.service;


import com.hardworking.training.model.Role;
import com.hardworking.training.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired RoleDao roleDao;

    public Role save(Role role){return roleDao.save(role);}

    public boolean delete(Long id){return roleDao.delete(id);}

    public Role getRoleByName(String name){return roleDao.getRoleByName(name);}

    public Role getRoleById(Long id){return roleDao.getRoleById(id);}
}
