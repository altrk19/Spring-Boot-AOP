package com.spring.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String printMessage(String param) {

        return param;
    }

    public void method(String parameter1){
        System.out.println(parameter1);
    }
}
