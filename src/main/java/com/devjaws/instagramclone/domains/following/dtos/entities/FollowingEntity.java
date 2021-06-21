package com.devjaws.instagramclone.domains.following.dtos.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FollowingEntity {
    private Integer userId;
    private Integer profileId;
}
