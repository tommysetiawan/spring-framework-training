package com.blibli.test.blogapp.controller;

import com.blibli.test.blogapp.dto.DeleteUserResponse;
import com.blibli.test.blogapp.dto.UserRequest;
import com.blibli.test.blogapp.dto.UserResponse;
import com.blibli.test.blogapp.entity.User;
import com.blibli.test.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tommy.setiawan on 3/12/2020.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET,
            produces ={MediaType.APPLICATION_JSON_VALUE})
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean addUser(@RequestBody UserRequest request){
        userService.addUser(request);
        return true;
    }

    @RequestMapping(path="/{id}",method = RequestMethod.DELETE)
    public DeleteUserResponse deleteUser(@PathVariable(name = "id") Long id){
        DeleteUserResponse response = new DeleteUserResponse();
        try {
            userService.deleteUser(id);
            response.setSuccess(true);
        } catch(Exception e){
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}
