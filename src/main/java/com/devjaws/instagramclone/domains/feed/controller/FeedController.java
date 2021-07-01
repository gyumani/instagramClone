package com.devjaws.instagramclone.domains.feed.controller;

import com.devjaws.instagramclone.domains.comment.dtos.entities.CommentEntity;
import com.devjaws.instagramclone.domains.comment.service.CommentService;
import com.devjaws.instagramclone.domains.feed.dtos.MainDTO;
import com.devjaws.instagramclone.domains.feed.dtos.entities.FeedEntity;
import com.devjaws.instagramclone.domains.feed.service.FeedService;
import com.devjaws.instagramclone.domains.file.util.FileUploder;
import com.devjaws.instagramclone.domains.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private FeedService feedService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;


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
        List<MainDTO> main= feedService.main(model);
        List<CommentEntity> comment=commentService.getList(model);
        model.addAttribute("main", main);
        model.addAttribute("comment",comment);

        return "board/feed";
    }
    @GetMapping("/feed/updateForm/{id}")
    public String updatePostForm(){
        return "board/updateForm";
    }


}
