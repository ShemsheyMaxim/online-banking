package com.springboot.onlinebanking.controller;

import com.springboot.onlinebanking.model.Role;
import com.springboot.onlinebanking.model.User;
import com.springboot.onlinebanking.service.RoleService;
import com.springboot.onlinebanking.service.UserService;
import java.time.LocalDate;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InjectData {
    private final UserService userService;
    private final RoleService roleService;

    @PostConstruct
    private void injectRole() {
        Role roleUser = new Role();
        roleUser.setRoleName(Role.RoleName.USER);
        roleService.save(roleUser);
        Role roleAdmin = new Role();
        roleAdmin.setRoleName(Role.RoleName.ADMIN);
        roleService.save(roleAdmin);

        User max = new User();
        max.setName("Max");
        max.setPassword("max123");
        max.setDateOfBirth(LocalDate.of(1997, 4, 4));
        max.setPhoneNumber("+380956655267");
        max.setRoles(Set.of(roleAdmin));
        userService.save(max);
        System.out.println(max);
    }
}
