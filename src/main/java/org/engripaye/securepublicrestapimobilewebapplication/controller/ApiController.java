package org.engripaye.securepublicrestapimobilewebapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiController {

    @GetMapping("/public")
    public Map<String, String> publicEndPoint(){
        return Map.of("message", "This ia a  public endpoint, No token required");

    }

    @GetMapping("/secure")
    public Map<String, String> secureEndPoint() {
        return Map.of("message", "This is a secure endpoint, Your JWT token was accepted, YOU ARE WELCOME !");
    }
}
