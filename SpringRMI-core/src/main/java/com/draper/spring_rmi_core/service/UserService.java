package com.draper.spring_rmi_core.service;

import com.draper.spring_rmi_core.model.User;

public interface UserService {

    boolean insertUserByPhone(User user);

    boolean insertUserByEmail(User user);

    User selectUserByPhone(String phone);

    User selectUserByEmail(String email);

}
