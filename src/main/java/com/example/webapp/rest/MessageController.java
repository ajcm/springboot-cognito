package com.example.webapp.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/rest")
public class MessageController {
    Logger logger = LoggerFactory.getLogger(MessageController.class);


    @GetMapping("auth")
    public ResponseEntity<Principal> get(Principal principal) {
        if (principal != null) {
            return ResponseEntity.ok(principal);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("test")
    public ResponseEntity<String> test(Principal principal, @Value("${app.test.message}") String msg) {

        return ResponseEntity.ok(msg);
    }

    @GetMapping("env")
    public Map<String, String> getAllEnvVariables() {

        return System.getenv();


    }

}
