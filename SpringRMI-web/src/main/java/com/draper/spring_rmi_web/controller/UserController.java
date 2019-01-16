package com.draper.spring_rmi_web.controller;

import com.draper.spring_rmi_core.service.UserService;
import com.draper.spring_rmi_core.model.User;
import com.draper.spring_rmi_web.util.RandomCodeUtil;
import com.draper.spring_rmi_web.util.SMSManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@RequestMapping("/user")
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/loginIn")
    private String loginInGet() {
        return "user/loginIn";
    }

    @GetMapping("/loginUp/p")
    private String loginUpPhoneGet() {
        return "user/loginUpPhone";
    }

    @GetMapping("/loginUp/e")
    private String loginUpEmailGet() {
        return "user/loginUpEmail";
    }

    @PostMapping("/loginUp/p")
    private String loginUpPhonePost(@RequestParam Map<String, String> params) {
        String name = params.get("name");
        String firstPassword = params.get("firstPassword");
        String secondPassword = params.get("secondPassword");
        String phoneNumber = params.get("phoneNumber");
        String verifyCode = params.get("verifyCode");

        User user = new User();
        user.setName(name);
        user.setPassword(firstPassword);
        user.setPhone(phoneNumber);

        log.warn("user phone = [{}] login up", phoneNumber);
        boolean result = userService.insertUserByPhone(user);
        log.warn("user login up result = [{}]", result);
        return "index";
    }

    @PostMapping("/loginUp/e")
    private String loginUpEmailPost(@RequestParam Map<String, String> params) {
        String name = params.get("name");
        String firstPassword = params.get("firstPassword");
        String secondPassword = params.get("secondPassword");
        String email = params.get("email");
        String verifyCode = params.get("verifyCode");

        User user = new User();
        user.setName(name);
        user.setPassword(firstPassword);
        user.setEmail(email);

        log.warn("user email = [{}] login up", email);
        boolean result = userService.insertUserByPhone(user);
        log.warn("user login up result = [{}]", result);
        return "index";
    }

    @Autowired
    private SMSManager smsManager;

    @PostMapping("/sendPhoneCode")
    private void sendPhoneCodePost(@RequestParam("phone") String phone) {
        smsManager.sendTemplateSMS(phone, "1", new String[]{String.valueOf(RandomCodeUtil.build()), "15"});
    }

    @PostMapping("/sendEmailCode")
    private String sendEmailCodePost(@RequestParam("email") String email) {
        return "index";
    }


}
