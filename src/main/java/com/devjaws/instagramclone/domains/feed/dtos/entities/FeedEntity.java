package com.devjaws.instagramclone.domains.feed.dtos.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class FeedEntity {

    private Integer id;
    private Integer userId;
    private String picture;
    private String content;
    private Integer likeCount;
    private LocalDate createDate;
    private LocalDate updateDate;

    public FeedEntity(String content) {
        this.content = content;
    }
}
