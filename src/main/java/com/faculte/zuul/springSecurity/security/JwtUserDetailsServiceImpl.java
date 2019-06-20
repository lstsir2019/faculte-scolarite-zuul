/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.zuul.springSecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.faculte.zuul.springSecurity.repository.UserRepository;
import com.faculte.zuul.springSecurity.model.User;

/**
 *
 * @author abdou
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null ) {
            throw  new UsernameNotFoundException(String.format("No user found with username '%s' ", username));
        }else{
            return JwtUserFactory.create(user);
        }
    



    }
}
