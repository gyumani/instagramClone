package com.devjaws.instagramclone.domains.feed.controller;

import com.devjaws.instagramclone.domains.feed.dtos.entities.FeedEntity;
import com.devjaws.instagramclone.domains.feed.service.FeedService;
import com.devjaws.instagramclone.domains.file.util.FileUploder;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private FeedService feedService;


    @GetMapping("/feed/insertForm")
    public String insertPost(){return "/board/insertForm";}
    @PostMapping("/feed/insertProc")
    public String insertFeed(Principal principal, FeedEntity feedEntity, @RequestParam("file") MultipartFile file) throws Exception {

        String filetxt= StringUtils.cleanPath(file.getOriginalFilename());
        feedEntity.setUsername(principal.getName());
        feedEntity.setPicture(filetxt);
        feedService.regi(feedEntity);
        FileUploder.uploadPost(file, filetxt, principal.getName());
        return "board/profile";
    }

    @GetMapping({"/","/feed"})
    public String feedList(Model model) throws Exception{
        List<FeedEntity> main= feedService.main(model);
        model.addAttribute("main", main);
        return "board/feed";
    }

    @GetMapping("/feed/profile/{username}")
    public String getpp (@PathVariable String username, Model model) throws Exception{
        List<FeedEntity> getpp= feedService.getpp(username);
        model.addAttribute("getpp", getpp);
        return "board/profile";
    }
}
