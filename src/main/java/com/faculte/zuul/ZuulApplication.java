package com.faculte.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
  @Bean
        public CorsFilter corsFilter(){
             final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
             final CorsConfiguration config = new CorsConfiguration();
             config.setAllowCredentials(true);
             config.addAllowedHeader("*");
             config.addAllowedOrigin("*");
             config.addAllowedMethod("POST");
             config.addAllowedMethod("GET");
             config.addAllowedMethod("PUT");
             config.addAllowedMethod("DELETE");
             source.registerCorsConfiguration("/**", config);
             return new CorsFilter(source);
             
        }
}
