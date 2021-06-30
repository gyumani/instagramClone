package com.devjaws.instagramclone.domains.feed.dtos.entities;

import com.devjaws.instagramclone.domains.comment.dtos.entities.CommentEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FeedEntity {

    private Integer id;
    private String username;
    private String picture;
    private String content;
    private LocalDate createDate;
    private LocalDate updateDate;
    private List<CommentEntity> commentEntities;

    @Builder
    public FeedEntity(String picture, String content) {
        this.picture = picture;
        this.content = content;
    }
}
