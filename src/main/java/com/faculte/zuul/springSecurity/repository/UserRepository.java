/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.zuul.springSecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.faculte.zuul.springSecurity.model.User;

/**
 *
 * @author abdou
 */


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
    public User findByEmail(String username);
}
