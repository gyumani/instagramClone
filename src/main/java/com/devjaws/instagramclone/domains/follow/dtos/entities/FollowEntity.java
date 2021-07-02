package com.devjaws.instagramclone.domains.follow.dtos.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FollowEntity {
    private Integer id;
    private Integer userId;
    private Integer followId;

    @Builder
    public FollowEntity(Integer id, Integer userId, Integer followId) {
        this.id = id;
        this.userId = userId;
        this.followId = followId;
    }
}
