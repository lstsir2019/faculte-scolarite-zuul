/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.zuul.springSecurity.service;

import java.util.List;
import com.faculte.zuul.springSecurity.model.User;

/**
 *
 * @author abdou
 */
public interface UserService {

    public User save(User user);

    public List<User> findAll();

    public User getUserByEmail(String username);
    
}
