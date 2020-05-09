package com.spring.aop.controller;

import com.spring.aop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class Controller {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> method(@RequestBody String message) {
        return ResponseEntity.ok(messageService.printMessage(message));
    }
}
//POST localhost:8080/message
////{
////        "message":"ali"
////}