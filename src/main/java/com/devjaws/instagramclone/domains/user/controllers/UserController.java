package com.devjaws.instagramclone.domains.user.controllers;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.feed.dtos.MainDTO;
import com.devjaws.instagramclone.domains.feed.service.FeedService;
import com.devjaws.instagramclone.domains.file.util.FileUploder;
import com.devjaws.instagramclone.domains.follow.dtos.entities.FollowEntity;
import com.devjaws.instagramclone.domains.follow.service.FollowService;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.services.UserService;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private FollowService followService;

    @Autowired
    private FeedService feedService;

    //유저 기능 관련

    @GetMapping("/user/updateUserForm")
    public String updateForm() {return  "user/updateUserForm"; }

    @PostMapping("/user/updateUserProc")
    public RedirectView updateUser(UserEntity userEntity){
        userService.updateUser(userEntity);

//        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntity.getUsername(),userEntity.getPassword()));
//        logger.info("=========>{}",authentication.getPrincipal().getClass().getName());

//        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/");
    }

    @PostMapping("/user/deleteUser")
    public String deleteUser(@RequestParam("id") Integer id, RedirectAttributes rttr){
        if(userService.deleteUser(id)){
            rttr.addFlashAttribute("result","success");
        }
        return "user/loginForm";
    }


    //프로필 기능 관련

    @PostMapping("/user/profile/insertProc")
    public String insertProfile(Principal principal, UserEntity userEntity, @RequestParam("file") MultipartFile file) throws Exception {
        String filetxt= StringUtils.cleanPath(file.getOriginalFilename());
        userEntity.setPicture(filetxt);
        userService.updateProfile(userEntity);
        FileUploder.uploadProfile(file, filetxt, principal.getName());
        return "user/profile";
    }


    @GetMapping("/user/editProfile")
    public String editProfile(){
        return "/user/editProfile";
    }


    @GetMapping("/user/profile/{username}")
    public String getpp (@PathVariable String username,Principal principal, Model model) throws Exception{
        List<MainDTO> getpp= feedService.getpp(username);
        UserEntity info=userService.profile(username);
        model.addAttribute("getpp", getpp);
        model.addAttribute("info",info);

        return "user/profile";
    }


    @GetMapping("/p/{id}")
    public String getPostModel (@PathVariable Integer id, Model model) throws Exception{
        MainDTO post=feedService.getPost(id);
        model.addAttribute("post",post);

        return "board/profile";
    }
}
