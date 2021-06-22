package com.devjaws.instagramclone.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
    @GetMapping("/")
    public String home(){
        return "/board/feed";
    }
}
