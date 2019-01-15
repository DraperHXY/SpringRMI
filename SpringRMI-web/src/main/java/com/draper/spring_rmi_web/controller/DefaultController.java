package com.draper.spring_rmi_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("")
    private String index1(){
        return "index";
    }

}
