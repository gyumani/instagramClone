package com.devjaws.instagramclone.domains.auth.controller;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.auth.service.AuthService;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {
    //로그인, 회원가입과 관련하여 추가
    @Autowired
    private UserService userService;
    //아이디를 찾아내기 위해 DAO 추가
    @Autowired
    private CommonDao commonDao;

    @Autowired
    private AuthService authService;


    // 회원가입 페이지
    @GetMapping("/auth/joinForm")
    public String joinForm(){ return "auth/joinForm"; }

    @GetMapping("/auth/loginForm")
    public String loginForm() {return "auth/loginForm"; }


    @PostMapping("/auth/joinProc")
    public String join(UserEntity userEntity){
        if(authService.findById(userEntity.getUsername())==true){
            return "auth/loginForm";
        }
        authService.join(userEntity);
        return "auth/loginForm";
    }

}
