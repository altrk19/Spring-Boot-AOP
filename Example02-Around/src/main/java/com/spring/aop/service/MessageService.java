package com.spring.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String printMessage(String param) {
        method("param test");
        return param;
    }

    public void voidMethod(String param) {
        System.out.println("hello");
    }

    private void method(String parameter1){
        System.out.println(parameter1);
    }
}
