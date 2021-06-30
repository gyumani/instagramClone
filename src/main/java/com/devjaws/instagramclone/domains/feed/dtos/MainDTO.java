package com.devjaws.instagramclone.domains.feed.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class MainDTO {
    @NotBlank
    private Integer id;
    @NotBlank
    private String postUsername;
    @NotBlank
    private String commentUsername;
    @NotBlank
    private String postPicture;
    @NotBlank
    private String profilePicture;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String bio;
    private String website;
    private String postContent;
    private String commentContent;

    @Builder
    public MainDTO(String postUsername, String commentUsername, String postPicture, String profilePicture, String firstName, String lastName, String bio, String website, String postContent, String commentContent) {
        this.postUsername = postUsername;
        this.commentUsername = commentUsername;
        this.postPicture = postPicture;
        this.profilePicture = profilePicture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.website = website;
        this.postContent = postContent;
        this.commentContent = commentContent;
    }
}
