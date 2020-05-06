package com.snowcoder.onlinestore.controller;

import com.snowcoder.onlinestore.exception.ResourceNotFoundException;
import com.snowcoder.onlinestore.model.User;
import com.snowcoder.onlinestore.service.serviceimpl.UserServiceImpl;
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
    private UserServiceImpl userServiceImpl;

    @Autowired
    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/get-all-users")
    public ResponseEntity<?> getUsers(){
        Iterable<User> users = userServiceImpl.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/get-user/{name}")
    public ResponseEntity<?> getUsers(@PathVariable String name){
        List<User> users = userServiceImpl.findUserByFirstName(name);
        if(users.isEmpty())
            throw new ResourceNotFoundException("No user with name " + name + " exists");
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/add")
    public User createUser(@Valid @RequestBody User user){
        return userServiceImpl.createUser(user);
    }

    @GetMapping(value = "/get-users-count")
    public ResponseEntity<Integer> getUsercount(){
        return ResponseEntity.ok().body(userServiceImpl.getTotalUsers());
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        User user = userServiceImpl.findUser(id)
                        .orElseThrow(() -> new ResourceNotFoundException("user with id " + id + " not found"));
        userServiceImpl.deleteUser(user);
    }
}
