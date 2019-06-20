/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.zuul.springSecurity.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.faculte.zuul.springSecurity.repository.UserRepository;
import com.faculte.zuul.springSecurity.model.User;
import com.faculte.zuul.springSecurity.util.PasswordUtil;

/**
 *
 * @author abdou
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    
    
    @Autowired 
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        String password = PasswordUtil.getPasswordHash(user.getPassword());
        user.setPassword(password);
        user.setCreatedDate(new Date());
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    
}
