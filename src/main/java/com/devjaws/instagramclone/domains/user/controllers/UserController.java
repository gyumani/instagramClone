package com.devjaws.instagramclone.domains.user.controllers;

import com.devjaws.instagramclone.domains.user.dtos.SignUpDTO;
import com.devjaws.instagramclone.domains.user.services.UserService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinProc")
    public String join(@RequestBody SignUpDTO signUpDTO, HttpServletResponse response){
        var user=userService.signUp(signUpDTO);
        return "/";
    }


}
