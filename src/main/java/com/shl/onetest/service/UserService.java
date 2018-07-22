package com.shl.onetest.service;

import com.shl.onetest.domain.User;
import com.shl.onetest.domain.UserWithRole;
import com.shl.onetest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    UserWithRole findById(Long userId){
        return  null;
    }



    public List<User> findUserWithDept(User user){
        return  null;
    }

    void registUser(User user){

    }

    public void updateTheme(String theme, String userName){

    }

    void addUser(User user, Long[] roles){

    }

    void updateUser(User user, Long[] roles){

    }

    void deleteUsers(String userIds){

    }

    void updateLoginTime(String userName){

    }

    void updatePassword(String password){

    }

    User findUserProfile(User user){
        return  null;
    }

    void updateUserProfile(User user){

    }
}
