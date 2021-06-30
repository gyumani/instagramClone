package com.devjaws.instagramclone.domains.comment.controller.api;

import com.devjaws.instagramclone.common.dto.ResponseDTO;
import com.devjaws.instagramclone.domains.comment.dtos.entities.CommentEntity;
import com.devjaws.instagramclone.domains.comment.service.CommentService;
import com.sun.xml.internal.ws.api.model.MEP;
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

    @PostMapping(value="/comments/insert", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public void create(@RequestBody CommentEntity commentEntity){
        commentService.insertComment(commentEntity);
    }


}
