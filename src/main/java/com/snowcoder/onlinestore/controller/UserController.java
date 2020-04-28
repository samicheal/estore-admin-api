package com.snowcoder.onlinestore.controller;

import com.snowcoder.onlinestore.exception.ResourceNotFoundException;
import com.snowcoder.onlinestore.model.User;
import com.snowcoder.onlinestore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class.getName());
    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/get-all-users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/add")
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping(value = "/get-users-count")
    public ResponseEntity<Integer> getUsercount(){
        return ResponseEntity.ok().body(userService.getTotalUsers());
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping(value = "/add/{id}")
    public User updateUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }
}
