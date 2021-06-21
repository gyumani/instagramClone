package com.devjaws.instagramclone.domains.user.dtos.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProfileEntity {
    private Integer userId;
    private Integer id;
    private String profileTitle;
    private String profileContent;
    private LocalDate createDate;
    private LocalDate updateDate;
    private Integer fileId;

    @Builder
    public ProfileEntity(String profileTitle, String profileContent) {
        this.profileTitle = profileTitle;
        this.profileContent = profileContent;
    }
}
