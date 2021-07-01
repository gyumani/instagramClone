package com.devjaws.instagramclone.domains.user.controllers.api;

import com.devjaws.instagramclone.domains.feed.dtos.MainDTO;
import com.devjaws.instagramclone.domains.feed.service.FeedService;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserApiController {


    @Autowired
    private UserService userService;

    @Autowired
    private FeedService feedService;

//    @RequestMapping(value="/p/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public void selectPost(@PathVariable Integer id, Model model) throws Exception{
//        MainDTO post=feedService.getPost(id);
//        model.addAttribute("post",post);
//    }

}
