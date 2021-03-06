package com.draper.spring_rmi_service.mapper;

import com.draper.spring_rmi_core.model.User;

public interface UserMapper {

    void insertByPhone(User user);

    void insertByEmail(User user);

    User selectByPhone(String phone);

    User selectByEmail(String email);

}
