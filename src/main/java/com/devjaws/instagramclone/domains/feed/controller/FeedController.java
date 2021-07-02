package com.devjaws.instagramclone.domains.feed.controller;

import com.devjaws.instagramclone.configs.auth.PrincipalDetail;
import com.devjaws.instagramclone.domains.comment.dtos.entities.CommentEntity;
import com.devjaws.instagramclone.domains.comment.service.CommentService;
import com.devjaws.instagramclone.domains.feed.dtos.MainDTO;
import com.devjaws.instagramclone.domains.feed.dtos.entities.FeedEntity;
import com.devjaws.instagramclone.domains.feed.service.FeedService;
import com.devjaws.instagramclone.domains.file.util.FileUploder;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.services.UserService;
import com.fasterxml.jackson.databind.ser.std.FileSerializer;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class FeedController {
    private Logger logger = LoggerFactory.getLogger(FeedController.class);
    @Autowired
    private FeedService feedService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    //포스트 추가기능
    @GetMapping("/feed/insertForm")
    public String insertPost(){return "feed/insertForm";}
    @PostMapping("/feed/insertProc")
    public String insertFeed(Principal principal, FeedEntity feedEntity, @RequestParam("file") MultipartFile file) throws Exception {
        String filetxt= StringUtils.cleanPath(file.getOriginalFilename());
        feedEntity.setUsername(principal.getName());
        feedEntity.setPicture(filetxt);
        feedService.regi(feedEntity);
        FileUploder.uploadPost(file, filetxt, principal.getName());
        return "user/profile";
    }

    //메인화면 포스트 보여주기
    @GetMapping({"/","/feed"})
    public String feedList(Model model,FeedEntity feedEntity) throws Exception{
        List<MainDTO> main= feedService.main(model);
        main.forEach(feed->{
            feed.setCommentEntityList(commentService.get(feed.getId()));
        });
        model.addAttribute("main", main);

        UserEntity user = ((PrincipalDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserEntity();

        logger.info("====================>{}", user.getPassword());
        return "feed/feed";
    }

    //포스트 수정기능
    @GetMapping("/feed/updateForm/{id}")
    public String updatePostForm(@PathVariable Integer id,Model model){
        MainDTO post=feedService.getPost(id);
        model.addAttribute("post",post);
        return "feed/updateForm";
    }
    @PostMapping("/feed/updateProc/{id}")
    public String updatePost(@PathVariable Integer id, FeedEntity feedEntity , @RequestParam("file") MultipartFile file, Principal principal) throws Exception{
        Integer postid= feedService.getPostId(id);
        String filetxt= StringUtils.cleanPath(file.getOriginalFilename());
        feedEntity.setId(postid);
        feedEntity.setPicture(filetxt);
        feedService.updatePost(feedEntity);
        FileUploder.uploadPost(file, filetxt, principal.getName() );
        return "feed/feed";
    }

    @PostMapping("/feed/delete")
    public String deleteUser(@RequestParam("id") Integer id, RedirectAttributes rttr){
        if(feedService.deletePost(id)){
            rttr.addFlashAttribute("result","success");
        }
        return "user/loginForm";
    }


}
