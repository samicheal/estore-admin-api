package com.snowcoder.onlinestore.service;

import com.snowcoder.onlinestore.model.User;
import com.snowcoder.onlinestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Iterable<User> getAllUsers();

    Iterable<User> findUserByFirstName(String name);

    User createUser(User user);

    int getTotalUsers();

    int getTotalUsersFromPreviousMonth();

    int getTotalUsersFromCurrentMonth();

    void deleteUser(User user);

    Optional<User> findUser(Long id);

}