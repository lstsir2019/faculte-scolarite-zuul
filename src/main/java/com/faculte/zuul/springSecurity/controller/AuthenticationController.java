/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.zuul.springSecurity.controller;

import com.faculte.zuul.UnauthorizedException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.faculte.zuul.springSecurity.domain.UserDTO;
import com.faculte.zuul.springSecurity.model.User;
import com.faculte.zuul.springSecurity.repository.UserRepository;
import com.faculte.zuul.springSecurity.security.JwtTokenUtil;
import com.faculte.zuul.springSecurity.security.JwtUser;
import com.faculte.zuul.springSecurity.util.PasswordUtil;

/**
 *
 * @author abdou
 */
@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/api/user/login")
    public ResponseEntity<UserDTO> login(@RequestBody User user,HttpServletRequest request,HttpServletResponse response  ){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            final JwtUser userDetails = (JwtUser) authentication.getPrincipal();
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtil.generateToken(userDetails) ;
            response.setHeader("Token", token);
            return new ResponseEntity<UserDTO>(new UserDTO(userDetails.getUser(), token),HttpStatus.OK);
        } catch (Exception e) {
            throw  new UnauthorizedException(e.getMessage());
        }
    }
    
    @GetMapping("/api/user/find")
    public int findUser(@RequestBody User user){
        User u = userRepository.findByEmail(user.getEmail());
        if (u.getPassword().equals(PasswordUtil.getPasswordHash(user.getPassword())) && u.getRole().equals("ADMIN")) {
            return 1;
        }else{
            return -1;
        }
    }
}
