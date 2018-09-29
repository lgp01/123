package com.lgp.service;

import javax.servlet.http.HttpSession;

import com.lgp.domain.User;

public interface UserService {

    boolean save(User user);
   
    boolean changePass(String pass,int uid);
    boolean selectByUserName(String username);
    boolean selectByEmail(String email);
	
	User login(String name, String pass);

}
