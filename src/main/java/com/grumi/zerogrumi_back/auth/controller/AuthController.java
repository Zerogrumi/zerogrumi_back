package com.grumi.zerogrumi_back.auth.controller;

import com.grumi.zerogrumi_back.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/test")
    public String test(){
        return "test success.";
    }
}
