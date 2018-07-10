package com.shl.onetest.service;

import com.shl.onetest.domain.User;
import com.shl.onetest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author songhongli
 **/
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User findByName(String userName){
        User user = userMapper.findByName(userName);
        return user;
    }
}
