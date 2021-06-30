package com.devjaws.instagramclone.domains.comment.controller;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.comment.dtos.entities.CommentEntity;
import com.devjaws.instagramclone.domains.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

//    @GetMapping("/")
//    public String getList(@PathVariable Integer id, Model model){
//        List<CommentEntity> list=commentService.getList(id);
//        model.addAttribute("getListC",list);
//        return "/";
//    }

}
