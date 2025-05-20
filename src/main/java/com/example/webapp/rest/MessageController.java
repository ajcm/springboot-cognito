package com.example.webapp.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping(path = "/rest")
public class MessageController {
    Logger logger = LoggerFactory.getLogger(MessageController.class);


    @GetMapping()
    public ResponseEntity<OAuth2User>  get( Principal principal) {

        if (principal instanceof   OAuth2AuthenticationToken token ){
            return ResponseEntity.ok(token.getPrincipal());
        }
       
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("env")
    public ResponseEntity<String>  test(Principal principal, @Value("${app.test.message}") String msg) {

        return ResponseEntity.ok(msg);
    }


}
