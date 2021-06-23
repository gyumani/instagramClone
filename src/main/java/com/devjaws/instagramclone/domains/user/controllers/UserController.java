package com.devjaws.instagramclone.domains.user.controllers;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.services.UserService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CommonDao commonDao;

    public boolean findById(String username) { return commonDao.getData("User.existUsername",username); }

    // 회원가입 페이지
    @GetMapping("/auth/joinForm")
    public String joinForm(){ return "user/joinForm"; }

    @GetMapping("/auth/loginForm")
    public String loginForm() {return "user/loginForm"; }


    @PostMapping("/auth/joinProc")
    public String join(UserEntity userEntity){
        if(findById(userEntity.getUsername())==true){
            return "user/loginForm";
        }
        userService.join(userEntity);
        return "user/loginForm";
    }

    @GetMapping("/updateUserForm")
    public String updateForm() {return  "user/updateUserForm"; }

    @PostMapping("/updateUserProc")
    public String updateUser(UserEntity userEntity){
        userService.updateUser(userEntity);
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntity.getUsername(),userEntity.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "/";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(UserEntity userEntity){
        userService.deleteUser(userEntity);
        return "/";
    }


}
