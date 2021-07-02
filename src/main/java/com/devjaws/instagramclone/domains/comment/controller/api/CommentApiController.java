package com.devjaws.instagramclone.domains.comment.controller.api;

import com.devjaws.instagramclone.common.dto.ResponseDTO;
import com.devjaws.instagramclone.domains.comment.dtos.entities.CommentEntity;
import com.devjaws.instagramclone.domains.comment.service.CommentService;
import com.devjaws.instagramclone.domains.user.services.UserService;
import com.google.gson.Gson;
import com.sun.xml.internal.ws.api.model.MEP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @PostMapping(value="/comments/insert", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public void create(@RequestBody CommentEntity commentEntity){
        logger.info("====>{}", new Gson().toJson(commentEntity));

        commentService.insertComment(commentEntity);
    }

    @DeleteMapping(value="/comment/delete/{id}")
    public void delete(@PathVariable Integer id){
        commentService.remove(id);
    }


}
