package kr.co.gyusta.module.domains.user.dtos.entities;

import kr.co.gyusta.module.domains.user.role.RoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String bio;
    private String picture;
    private String website;
    private LocalDate createDate; //가입일자(자동생성)

    @Builder
    public UserEntity(String username, String password, String email, String firstName, String lastName, RoleType role, String bio, String picture, String website) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.bio = bio;
        this.picture = picture;
        this.website = website;
    }
}
