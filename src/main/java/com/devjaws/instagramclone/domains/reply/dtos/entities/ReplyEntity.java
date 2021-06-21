package com.devjaws.instagramclone.domains.reply.dtos.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ReplyEntity {
    private Integer id;
    private Integer userId;
    private Integer feedId;
    private String content;
    private LocalDate createDate;

    @Builder
    public ReplyEntity(String content) {
        this.content = content;
    }
}
