package com.lgp.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgp.domain.User;
import com.lgp.mapper.UserMapper;
import com.lgp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;
    @Override
    public boolean save(User user) {
        return mapper.insert(user)>0;
    }

    @Override
    public User login(String name,String pass) {
        User user= mapper.selectByName(name);
        if(user!=null){
            if(Objects.equals(pass,user.getPassword())){
                //成功
                return user;
            }
           
        }

       
        return null;
    }

    @Override
    public boolean changePass(String pass, int uid) {
        return mapper.updatePassword(pass,uid)>0;
    }

    @Override
    public boolean selectByUserName(String username) {
        Integer id= mapper.selectByUserName(username);
      
        if(id!=null && id>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean selectByEmail(String email) {
        Integer id= mapper.selectByEmail(email);
        if(id!=null && id>0){
            return true;
        }else {
            return false;
        }
    }
}
