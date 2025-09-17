package com.windy.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String handleHelloService() {
        return "Hello from service";
    }
}
