package com.wuqaq.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String username) {
        System.out.println("greeting");
        return "hello " + username;
    }
}
