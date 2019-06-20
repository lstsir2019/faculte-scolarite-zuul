/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.zuul.springSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.faculte.zuul.springSecurity.domain.Response;
import com.faculte.zuul.springSecurity.model.User;
import com.faculte.zuul.springSecurity.service.UserService;

/**
 *
 * @author abdou
 */
@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class PreLoginController {
    
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/api/user/registration")
    public ResponseEntity<Response> registration (@RequestBody User user){
        User dbUser = userService.save(user);
        if (dbUser != null ) {
            return new ResponseEntity<Response>(new Response("User is saved successfully "),HttpStatus.OK);
        }
        return null;
    }
}
