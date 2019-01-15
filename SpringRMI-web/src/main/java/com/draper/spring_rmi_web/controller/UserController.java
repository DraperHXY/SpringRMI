package com.draper.spring_rmi_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("/loginIn")
    private String loginInGet(){
        return "user/loginIn";
    }

    @GetMapping("/loginUp/p")
    private String loginUpPhoneGet(){
        return "user/loginUpPhone";
    }

    @GetMapping("/loginUp/e")
    private String loginUpEmailGet(){
        return "user/loginUpEmail";
    }

}
