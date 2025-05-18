package com.example.webapp.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping(path = "/rest")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping()
    public ResponseEntity<OAuth2User>  greeting(@RequestParam(value = "name", defaultValue = "default message") String name, Principal principal) {

        if (principal instanceof   OAuth2AuthenticationToken token ){
            
            return ResponseEntity.ok(token.getPrincipal());
            
        }
       
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }


}
