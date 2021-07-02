package com.devjaws.instagramclone.test;

import com.devjaws.instagramclone.domains.auth.service.AuthService;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TestApiController {

    @Autowired
    private AuthService authService;

    @PostMapping("/test/insertUser")
    public void insertUserTest(UserEntity userEntity, HttpServletResponse response){
        authService.insert(userEntity);
        System.out.println("username: "+userEntity.getUsername());
    }

}
