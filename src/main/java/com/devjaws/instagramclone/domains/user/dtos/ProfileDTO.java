package com.devjaws.instagramclone.domains.user.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {
    private Integer id;
    private String username;
    private String picture;
    private String bio;
    private String website;
    private String firstName;
    private String lastName;

    @Builder
    public ProfileDTO(String username, String picture, String bio, String website, String firstName, String lastName) {
        this.username = username;
        this.picture = picture;
        this.bio = bio;
        this.website = website;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
