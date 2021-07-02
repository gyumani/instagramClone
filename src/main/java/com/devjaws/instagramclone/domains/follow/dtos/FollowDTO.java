package com.devjaws.instagramclone.domains.follow.dtos;

import lombok.Builder;

public class FollowDTO {
    private int followerNum;
    private int followingNum;

    @Builder

    public FollowDTO(int followerNum, int followingNum) {
        this.followerNum = followerNum;
        this.followingNum = followingNum;
    }
}
