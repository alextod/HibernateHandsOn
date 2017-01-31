package com.home.service;

import com.home.model.UserDetails;
import com.home.repository.UserHibernateRepository;
import com.home.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 21.01.2017.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserHibernateRepository userHibernateRepository;

    public List<UserDetails> getAllUsers(){
        List<UserDetails> userDetailsList = new ArrayList<>();
        userRepository.findAll().forEach(userDetailsList::add);
        return userDetailsList;
    }

    public List<UserDetails> createUserDetailsMock(){
        for(int i=1; i<=10; i++){
            UserDetails user = new UserDetails();
            user.setUserId(i);
            user.setUserName("UserName"+i);
            userRepository.save(user);
        }
        return getAllUsers();
    }

    public String saveUserHibernate(){
        return userHibernateRepository.saveUserHibernate();
    }

    public String getUserHibernate() {
        return userHibernateRepository.getUserHibernate();
    }

    public String deleteUserHibernate(){
        return userHibernateRepository.deleteUserHibernate();
    }

    public String updateUserSetNameTestUser(){
        return userHibernateRepository.updateUserSetNameTestUser();
    }
}
