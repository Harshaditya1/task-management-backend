package com.harsh.taskmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/harsh")
    public String hello() {
        return "Hello Saurav! Welcome to Task Management API.";
    }
}