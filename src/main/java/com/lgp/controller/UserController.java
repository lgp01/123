package com.lgp.controller;

import com.lgp.domain.User;
import com.lgp.service.UserService;
import com.lgp.vo.R;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService service;

    //注册
    @PostMapping("usersave.do")
    public String register(User user, Model model){
  
        
        user.setFlag(0);

        if(service.save(user)){
          
            //成功
            return "registerSuccess.jsp";
        }else{
            //失败
            model.addAttribute("msg","注册失败请稍后再试！");
            return "register.jsp";
        }
    }
    //登录
    @PostMapping("userlogin.do")
    public String login(String name, String password, HttpSession session,Model model){
        User user=service.login(name,password);
       if(user==null){
           model.addAttribute("msg","用户名或密码错误");
           return "login.jsp";
       }else{
           session.setAttribute("user",user);
           return "index.jsp";
       }
    }
    //注销
    @GetMapping("userloginout.do")
    public String loginout(HttpSession session){
        session.removeAttribute("user");
        return "login.jsp";
    }

    //验证用户名是否存在
    @GetMapping("username.do")
    @ResponseBody
    public R checkName(String userame){
        if(service.selectByUserName(userame)){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //验证邮箱是否存在
    @GetMapping("useremail.do")
    @ResponseBody
    public R checkEmail(String email){
        if(service.selectByEmail(email)){
            return R.ok();
        }else {
            return R.error();
        }
    }


}
