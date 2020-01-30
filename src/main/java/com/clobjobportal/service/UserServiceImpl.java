package com.clobjobportal.service;

import com.clobjobportal.model.User;
import com.clobjobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User user) {
        System.out.println("save successfully");
        userRepository.save(user);
    }
}
