package com.commerce.app.controller;

import com.commerce.app.entity.User;
import com.commerce.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }
    @PostMapping({"/registerNewUser"})
    public User registerNewUser(User user){
return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "this url is only accessible to admin";
    }

    @GetMapping({"/forUser"})
    public String forUser(){
        return "this url is only accessible to user";
    }
}
