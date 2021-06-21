package com.devjaws.instagramclone.domains.follower.dtos.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FollowerEntity {
    private Integer userId;
    private Integer profileId;
}
