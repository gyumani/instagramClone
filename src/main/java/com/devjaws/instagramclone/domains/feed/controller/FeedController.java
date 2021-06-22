package com.devjaws.instagramclone.domains.feed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedController {
    @GetMapping("/feed/profile")
    public String viewProfile(){
        return "/board/profile";
    }
    @GetMapping("/feed/editProfile")
    public String editProfile(){
        return "/board/editProfile";
    }
}
