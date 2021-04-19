package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchServiceWithRepo {
    @Autowired
    private UserRepository userRepository;

    public void createUserIndexBulk(final List<User> users){
        userRepository.saveAll(users);
    }

    public void createUserIndex(final  User user){
        userRepository.save(user);
    }
}
