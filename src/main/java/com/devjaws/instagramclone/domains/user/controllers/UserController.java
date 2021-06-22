package com.devjaws.instagramclone.domains.user.controllers;

import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.services.UserService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    // 회원가입 페이지
    @GetMapping("/auth/joinForm")
    public String joinForm(){ return "user/joinForm"; }

    @GetMapping("/auth/loginForm")
    public String loginForm() {return "user/loginForm"; }


    @PostMapping("/auth/joinProc")
    public String join(UserEntity userEntity){
        userService.join(userEntity);
        return "user/loginForm";
    }


}
