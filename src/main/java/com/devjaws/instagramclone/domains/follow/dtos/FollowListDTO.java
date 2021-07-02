package com.devjaws.instagramclone.domains.follow.dtos;

import lombok.Builder;

public class FollowListDTO {
    private Integer id;
    private Integer followId;
    private String username;
    private String picture;

    @Builder

    public FollowListDTO(Integer id, Integer followId, String username, String picture) {
        this.id = id;
        this.followId = followId;
        this.username = username;
        this.picture = picture;
    }
}
