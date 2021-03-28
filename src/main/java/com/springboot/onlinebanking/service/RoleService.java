package com.springboot.onlinebanking.service;

import com.springboot.onlinebanking.model.Role;

public interface RoleService {
    public Role save(Role role);

    Role getByName(String roleName);
}
