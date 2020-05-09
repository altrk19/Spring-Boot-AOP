package com.spring.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String printMessage(String param) {
        System.out.println("Called printMessage method:" + param);
        return param;
    }
}
