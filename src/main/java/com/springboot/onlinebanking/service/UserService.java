package com.springboot.onlinebanking.service;

import com.springboot.onlinebanking.model.User;
import java.util.List;

public interface UserService {
    User save(User user);

    User getById(Long id);

    List<User> getAll();

    void update(User user);

    void delete(User user);

    User findUserByUserNumber(String phoneNumber);
}
