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
    private Integer id;
    private String bio;
    private String picture;
    private String website;
    private String user_name;

    @Builder
    public ProfileEntity(Integer id, String bio, String picture, String website, String user_name) {
        this.id = id;
        this.bio = bio;
        this.picture = picture;
        this.website = website;
        this.user_name = user_name;
    }
}
