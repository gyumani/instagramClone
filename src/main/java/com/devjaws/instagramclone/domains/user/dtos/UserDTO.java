package com.devjaws.instagramclone.domains.user.dtos;

import com.devjaws.instagramclone.domains.feed.dtos.entities.FeedEntity;
import com.devjaws.instagramclone.domains.follower.dtos.entities.FollowerEntity;
import com.devjaws.instagramclone.domains.following.dtos.entities.FollowingEntity;
import com.devjaws.instagramclone.domains.user.dtos.entities.ProfileEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Profile;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    //user id
    private Integer id;
    //username
    private String username;
    //password
    private String password;
    //email
    private String email;
    //profile
    private ProfileEntity profile;
    //feed
    private FeedEntity feed;
    //follower
    private FollowerEntity follower;
    //following
    private FollowingEntity following;

    @Builder
    public UserDTO(Integer id, String username, String email, ProfileEntity profile, FeedEntity feed, FollowerEntity follower, FollowingEntity following){
        this.id=id;
        this.username=username;
        this.email=email;
        this.profile=profile;
        this.feed=feed;
        this.follower=follower;
        this.following=following;
    }
}
