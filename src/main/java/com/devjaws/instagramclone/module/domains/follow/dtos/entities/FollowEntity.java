package kr.co.gyusta.module.domains.follow.dtos.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FollowEntity {
    private Integer userId;
    private Integer followerId;
    private Integer followingId;

    @Builder
    public FollowEntity(Integer userId, Integer followerId, Integer followingId) {
        this.userId = userId;
        this.followerId = followerId;
        this.followingId = followingId;
    }
}
