package com.devjaws.instagramclone.domains.user.controllers;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.file.util.FileUploder;
import com.devjaws.instagramclone.domains.user.dtos.ProfileDTO;
import com.devjaws.instagramclone.domains.user.dtos.entities.ProfileEntity;
import com.devjaws.instagramclone.domains.user.services.ProfileService;
import com.devjaws.instagramclone.domains.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.channels.MulticastChannel;
import java.security.Principal;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @PostMapping("/Profile/insert")
    public String insertProfile(Principal principal, ProfileEntity profileEntity, @RequestParam("file") MultipartFile file) throws Exception {

        String filetxt= StringUtils.cleanPath(file.getOriginalFilename());
        profileEntity.setPicture(filetxt);
        profileEntity.setUser_name(principal.getName());
        profileService.insert(profileEntity);
        FileUploder.uploadProfile(file, filetxt, principal.getName());
        return "board/profile";
    }

    @GetMapping("/board/profile")
    public String profileList(Principal principal, Model model) throws Exception{
        List<ProfileDTO> viewProfile= profileService.profile(principal.getName());

        model.addAttribute("viewProfile",viewProfile);
        return "board/profile";
    }
}
