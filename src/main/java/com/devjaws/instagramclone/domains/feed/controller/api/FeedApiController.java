package com.devjaws.instagramclone.domains.feed.controller.api;

import com.devjaws.instagramclone.domains.comment.dtos.entities.CommentEntity;
import com.devjaws.instagramclone.domains.feed.dtos.entities.FeedEntity;
import com.devjaws.instagramclone.domains.feed.service.FeedService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FeedApiController {
    @Autowired
    private FeedService feedService;



}
