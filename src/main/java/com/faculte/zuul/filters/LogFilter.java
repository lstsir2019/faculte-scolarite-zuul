/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Component
public class LogFilter extends ZuulFilter {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Override
  public String filterType() {
      return "pre";
  }

  @Override
  public int filterOrder() {
      return 1;
  }

  @Override
  public boolean shouldFilter() {
      return true;
  }

  @Override
  public Object run() throws ZuulException {

      HttpServletRequest req = RequestContext.getCurrentContext().getRequest();

      log.info("**** Requête interceptée ! L'URL est : {} " , req.getRequestURL());

      return null;
  }
}