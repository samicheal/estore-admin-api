package com.snowcoder.onlinestore.service.serviceimpl;

import com.snowcoder.onlinestore.model.User;
import com.snowcoder.onlinestore.repository.UserRepository;
import com.snowcoder.onlinestore.service.UserService;
import com.snowcoder.onlinestore.service.generators.DateRangeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public List<User> findUserByFirstName(String name) {
        return userRepository.findByName(name);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public int getTotalUsers(){
       return userRepository.getTotalUsers();
    }

    @Override
    public int getTotalUsersFromPreviousMonth() {
        //return userRepository.getTotalUsersFromPreviousMonth(, );
        return 0;
    }

    @Override
    public int getTotalUsersFromCurrentMonth() {
        //return userRepository.getTotalUsersFromCurrentMonth( , );
        return 0;
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public Optional<User> findUser(Long id){
        return userRepository.findById(id);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
