package com.devjaws.instagramclone.test;

import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TestApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/test/insertUser")
    public void insertUserTest(UserEntity userEntity, HttpServletResponse response){
        userService.insert(userEntity);
        System.out.println("username: "+userEntity.getUsername());
    }

}
