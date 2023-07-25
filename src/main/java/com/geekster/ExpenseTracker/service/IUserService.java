package com.geekster.ExpenseTracker.service;

import com.geekster.ExpenseTracker.model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface IUserService {
    List<User> getUsers(Integer userId);

    void addUser(User user);

    JSONObject login(String userName, String password);

    void updateUser(User user, Integer userId);
}
