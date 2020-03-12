package com.blibli.test.blogapp.service.impl;

import com.blibli.test.blogapp.dto.UserRequest;
import com.blibli.test.blogapp.dto.UserResponse;
import com.blibli.test.blogapp.entity.User;
import com.blibli.test.blogapp.repository.UserRepository;
import com.blibli.test.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by tommy.setiawan on 3/12/2020.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user ->
                UserResponse.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .age(user.getAge()).build())
                .collect(Collectors.toList());
    }

    @Override
    public void addUser(UserRequest request) {
        User newUser =
                User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .age(request.getAge()).build();
        userRepository.save(newUser);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
        }
        else{
            throw new RuntimeException("User not found");
        }
    }
}
