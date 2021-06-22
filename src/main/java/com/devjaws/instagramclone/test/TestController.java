package com.devjaws.instagramclone.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test/index")
    public String testIndex(){return "index";}
}
