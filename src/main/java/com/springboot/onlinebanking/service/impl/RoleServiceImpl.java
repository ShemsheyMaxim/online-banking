package com.springboot.onlinebanking.service.impl;

import com.springboot.onlinebanking.exception.DataProcessingException;
import com.springboot.onlinebanking.model.Role;
import com.springboot.onlinebanking.repository.RoleRepository;
import com.springboot.onlinebanking.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.getRoleByRoleName(roleName).orElseThrow(() ->
                new DataProcessingException("Can't find role by name"));
    }
}
