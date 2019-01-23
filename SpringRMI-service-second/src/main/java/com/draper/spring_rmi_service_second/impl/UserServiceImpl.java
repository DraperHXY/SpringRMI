package spring_rmi_service_second.impl;

import com.draper.spring_rmi_core.model.User;
import com.draper.spring_rmi_core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import spring_rmi_service_second.mapper.UserMapper;

@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public boolean insertUserByPhone(User user) {
        log.warn("insert User, user phone = [{}]", user.getPhone());
        userMapper.insertByPhone(user);
        return true;
    }

    public boolean insertUserByEmail(User user) {
        log.warn("insert User, user email = [{}]", user.getEmail());
        userMapper.insertByEmail(user);
        return true;
    }

    public User selectUserByPhone(String phone) {
        log.warn("select User, user phone = [{}]", phone);
        return userMapper.selectByPhone(phone);
    }

    public User selectUserByEmail(String email) {
        log.warn("select User, user email = [{}]", email);
        return userMapper.selectByEmail(email);
    }

}
