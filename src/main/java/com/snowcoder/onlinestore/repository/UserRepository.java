package com.snowcoder.onlinestore.repository;

import com.snowcoder.onlinestore.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.name=?1")
    List<User> findByName(String name);

    @Query("select count(id) from User")
    int getTotalUsers();

//    @Query("")
//    int getTotalUsersFromPreviousMonth(String start, String end);
//
//    @Query("")
//    int getTotalUsersFromCurrentMonth(String start, String end);

}
