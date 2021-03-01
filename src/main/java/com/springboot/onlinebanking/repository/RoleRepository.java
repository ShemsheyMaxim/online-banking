package com.springboot.onlinebanking.repository;

import com.springboot.onlinebanking.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.roleName = :roleName")
    Optional<Role> getRoleByRoleName(String roleName);
}
