package com.devjaws.instagramclone.domains.user.dtos.entities;

import com.devjaws.instagramclone.domains.user.role.RoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    private Integer id; //회원 번호
    private String username; //아이디
    private String password; //패스워드
    private String email; //이메일
    private String firstName; //성
    private String lastName; //이름
    private RoleType role; //권한
    private LocalDate createDate; //가입일자(자동생성)

    @Builder
    public UserEntity(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
