package com.clobjobportal.service;


import com.clobjobportal.model.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}