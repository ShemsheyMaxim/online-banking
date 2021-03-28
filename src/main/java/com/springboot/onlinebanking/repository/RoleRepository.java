package com.springboot.onlinebanking.repository;

import com.springboot.onlinebanking.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getRoleByRoleName(Role.RoleName roleName);
}
