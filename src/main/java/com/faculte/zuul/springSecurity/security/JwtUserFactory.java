/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.zuul.springSecurity.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.faculte.zuul.springSecurity.model.User;

/**
 *
 * @author abdou
 */
public class JwtUserFactory {

   public static JwtUser create(User user) {
             return new JwtUser(user.getId(),user.getEmail() , user.getPassword(), user, mapToGrantedAuthorities(new ArrayList<String>(Arrays.asList("ROLE_" + user.getRole()))),user.isEnabled());
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
    return  authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
    }

}
