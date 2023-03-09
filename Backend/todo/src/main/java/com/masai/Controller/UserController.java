package com.masai.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/register")

    public String registerUser(){

        return "Hello i am User";
    }

    @GetMapping("/login")

    public String loginUser(){

        return "Hello Login";
    }
    
    
}
