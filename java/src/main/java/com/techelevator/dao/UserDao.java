package com.techelevator.dao;

import com.techelevator.model.User;

import java.security.Principal;
import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);

    public String getUserRole(String username);

    public void updateTotalMinutesRead(String username, int minutesToAdd);

    //TODO: get array of prizes won and current working prize.


}
