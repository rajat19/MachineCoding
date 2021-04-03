package com.paradox.trello.services;

import com.paradox.trello.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static UserService userService;
    private final Map<String, User> userMap;

    private UserService() {
        userMap = new HashMap<>();
    }

    public static synchronized UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void addUser(String id, String name, String email) {
        User user = new User(id, name, email);
        userMap.put(id, user);
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }
}
