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
    private String username;
    private String picture;
    private String content;
    private LocalDate createDate;
    private LocalDate updateDate;

    @Builder
    public FeedEntity(String picture, String content) {
        this.picture = picture;
        this.content = content;
    }
}
