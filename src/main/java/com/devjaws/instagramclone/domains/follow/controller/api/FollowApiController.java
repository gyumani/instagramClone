package com.devjaws.instagramclone.domains.follow.controller.api;

import com.devjaws.instagramclone.common.dto.ResponseDTO;
import com.devjaws.instagramclone.domains.follow.dtos.entities.FollowEntity;
import com.devjaws.instagramclone.domains.follow.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowApiController {

    @Autowired
    private FollowService followService;

    @PostMapping(value="/follow/follow", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public void follow(@RequestBody FollowEntity followEntity){
        followService.follow(followEntity);
    }
}
