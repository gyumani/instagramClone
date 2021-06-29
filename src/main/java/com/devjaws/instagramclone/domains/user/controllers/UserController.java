package com.devjaws.instagramclone.domains.user.controllers;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.file.util.FileUploder;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.services.UserService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.security.Principal;

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

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Integer id, RedirectAttributes rttr){
        if(userService.deleteUser(id)){
            rttr.addFlashAttribute("result","success");
        }
        return "/user/loginForm";
    }


    @PostMapping("/Profile/insert")
    public String insertProfile(Principal principal, UserEntity userEntity, @RequestParam("file") MultipartFile file) throws Exception {

        String filetxt= StringUtils.cleanPath(file.getOriginalFilename());
        userEntity.setPicture(filetxt);
        userService.updateProfile(userEntity);
        FileUploder.uploadProfile(file, filetxt, principal.getName());
        return "board/profile";
    }

    @GetMapping("/profile")
    public String profile() throws Exception{
        return "board/profile";
    }


}
