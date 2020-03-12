package com.blibli.test.blogapp.service;

import com.blibli.test.blogapp.dto.UserRequest;
import com.blibli.test.blogapp.dto.UserResponse;
import com.blibli.test.blogapp.entity.User;

import java.util.List;

/**
 * Created by tommy.setiawan on 3/12/2020.
 */
public interface UserService {
    List<UserResponse> getUsers();
    void addUser(UserRequest request);
    void deleteUser(Long id);
}
