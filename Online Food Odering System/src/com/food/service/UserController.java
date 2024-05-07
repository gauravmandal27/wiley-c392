package com.food.service;

import com.food.model.User;
import com.food.model.UserType;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private static Map<String,User> users;

    public UserController() {
        users=new HashMap<>();
        users.put("admin",new User("admin","admin",UserType.ADMIN));
    }

    public boolean hasUser(String userId){
        return users.containsKey(userId);
    }

    public static Map<String, User> getUsers() {
        return users;
    }

    public static void setUsers(Map<String, User> users) {
        UserController.users = users;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public UserType getUserType(String userId){
        return users.get(userId).getTypeOfUser();
    }

    public String getUserPassword(String userId){
        return users.get(userId).getPassword();
    }
    public void newUser(String userId,String password,UserType type){
        users.put(userId,new User(userId,password,type));
        System.out.println("New User Created Successfully\nYou can Proceed to Login!!");
    }
}
