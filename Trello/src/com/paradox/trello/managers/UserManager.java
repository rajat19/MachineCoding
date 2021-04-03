package com.paradox.trello.managers;

import com.paradox.trello.services.UserService;

public class UserManager implements IManager{
    private final UserService userService;
    private static UserManager userManager;

    private UserManager() {
        userService = UserService.getInstance();
    }

    public static synchronized UserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }


    @Override
    public void executeCommands(String[] commands) {
        if (commands[1].equals("ADD")) {
            userService.addUser(commands[2], commands[3], commands[4]);
        }
    }
}
