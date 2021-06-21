package com.devjaws.instagramclone.domains.user.dtos.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    private Integer id;
    private Integer profileId;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Integer followCount;
    private Integer followingCount;
    private LocalDate createDate;

    @Builder
    public UserEntity(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
