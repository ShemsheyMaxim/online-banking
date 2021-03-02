package com.springboot.onlinebanking.service.impl;

import com.springboot.onlinebanking.exception.DataProcessingException;
import com.springboot.onlinebanking.model.User;
import com.springboot.onlinebanking.repository.UserRepository;
import com.springboot.onlinebanking.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find user by id " + id + " from table."));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findUserByUserNumber(String phoneNumber) {
        return userRepository.findUserByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new DataProcessingException("Can't find user by phone number: "
                        + phoneNumber + " from table."));
    }
}
