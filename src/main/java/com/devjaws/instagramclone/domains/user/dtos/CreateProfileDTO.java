package com.devjaws.instagramclone.domains.user.dtos;

import javax.validation.constraints.NotBlank;

public class CreateProfileDTO {
    @NotBlank
    private String profileTitle;
    private String profileContent;
}
