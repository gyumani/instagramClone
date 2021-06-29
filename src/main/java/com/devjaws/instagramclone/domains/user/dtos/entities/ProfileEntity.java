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
    private Integer user_id;

    @Builder
    public ProfileEntity(Integer id, String bio, String picture, String website, Integer user_id) {
        this.id = id;
        this.bio = bio;
        this.picture = picture;
        this.website = website;
        this.user_id = user_id;
    }
}
