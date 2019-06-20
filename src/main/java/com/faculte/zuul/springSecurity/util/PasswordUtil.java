/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.zuul.springSecurity.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author abdou
 */
public class PasswordUtil {

    
    static  BCryptPasswordEncoder  encoder= new BCryptPasswordEncoder();
    public static String getPasswordHash(String password) {
        return encoder.encode(password);
       
    }
    
}
