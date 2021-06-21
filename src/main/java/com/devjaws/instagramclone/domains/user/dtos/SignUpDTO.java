package com.devjaws.instagramclone.domains.user.dtos;

import com.devjaws.instagramclone.domains.user.dtos.entities.ProfileEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class SignUpDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Valid
    private ProfileEntity profile;
}
