/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.zuul;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author abdou
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedException extends RuntimeException{
    
    protected static MessageSourceAccessor message  = SpringSecurityMessageSource.getAccessor();
    
    public UnauthorizedException(){
        super(message.getMessage("AbstractAccessDecisionManager.accessDenied","Access is denied"));
    }
    
    public UnauthorizedException(String message){
        super(message);
    }
}
