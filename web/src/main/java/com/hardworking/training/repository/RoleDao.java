package com.hardworking.training.repository;

import com.hardworking.training.model.Role;
import com.hardworking.training.model.User;

public interface RoleDao {
    Role save(Role role);
    boolean delete(Long id);
    Role getRoleByName(String name);
    Role getRoleById(Long id);
}
