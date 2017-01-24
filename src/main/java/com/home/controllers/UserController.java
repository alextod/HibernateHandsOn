package com.home.controllers;

import com.home.model.UserDetails;
import com.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Alex on 21.01.2017.
 */
@RestController
@RequestMapping("/userdetails")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserDetails> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/mock")
    public List<UserDetails> createUserDetailsMock(){
        return userService.createUserDetailsMock();
    }


    @RequestMapping(value = "/hibernate")
    public String saveUserHibernate(){
        return userService.saveUserHibernate();
    }

    @RequestMapping(value = "/hibernate/user1")
    public String getUserHibernate(){
        return userService.getUserHibernate();
    }
}
